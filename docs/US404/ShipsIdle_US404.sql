CREATE OR REPLACE PROCEDURE ShipsIdleUS404 (outString OUT VARCHAR2) IS

    allShipsMmsiCode VARCHAR(9);
    cargoManifestsOfAShipAux INTEGER;
    flag BOOLEAN;
    expectedArrivalDateAux TIMESTAMP;
    allCargoManifestsOfAShip INTEGER;
    expectedArrivalDateAux1 TIMESTAMP;

    CURSOR allShips IS
    SELECT mmsiCode
    FROM Ship;

    CURSOR cargoManifestsOfAShip IS
    SELECT CargoManifestLoad.id
    FROM CargoManifestLoad
    INNER JOIN Phases
    ON (cargoManifestLoad.Id = Phases.CargoManifestLoadId)
    WHERE shipMmsiCode = allShipsMmsiCode
    AND (EXTRACT (YEAR FROM expectedArrivalDate) = EXTRACT(YEAR FROM SYSDATE)
    OR EXTRACT (YEAR FROM expectedDepartureDate) = EXTRACT(YEAR FROM SYSDATE));

    BEGIN
        OPEN allShips;
        FETCH allShips INTO allShipsMmsiCode;
        EXIT WHEN allShips%notFound;

        LOOP
            flag := false;
            OPEN cargoManifestsOfAShip;
            FETCH cargoManifestsOfAShip INTO cargoManifestsOfAShipAux;
            EXIT WHEN cargoManifestsOfAShip%notFound;

            LOOP
                flag := true;

                FOR phasesPerYear IN
                (SELECT id, expectedDepartureDate
                FROM Phases
                WHERE cargoManifestLoadId = cargoManifestsOfAShipAux
                AND EXTRACT(YEAR FROM expectedDepartureDate) = EXTRACT(YEAR FROM SYSDATE))
                LOOP
                    SELECT COUNT(*) INTO allCargoManifestsOfAShip
                    FROM CargoManifestLoad
                    WHERE shipMmsiCode = allShipsMmsiCode;

                    IF phasesPerYear.id = 1 AND allCargoManifestsOfAShip > 1 THEN

                        SELECT id INTO idCargoManifest
                        FROM CargoManifestLoad
                        INNER JOIN Phases
                        ON (cargoManifestLoad.Id = Phases.CargoManifestLoadId)
                        WHERE isConcluded = 1
                        AND Phases.id = (SELECT MAX(id) FROM Phases WHERE cargoManifestLoadId = Phases.CargoManifestLoadId)
                        AND expectedArrivalDate = (SELECT MAX(expectedArrivalDate) FROM Phases WHERE cargoManifestLoadId = Phases.CargoManifestLoadId)
                        AND expectedArrivalDate < phasesPerYear.expectedDepartureDate;

                        SELECT expectedArrivalDate INTO expectedArrivalDateAux1
                        FROM Phases
                        WHERE CargoManifestLoadId = idCargoManifest
                        AND Phases.id = (SELECT MAX(id) FROM Phases WHERE cargoManifestLoadId = idCargoManifest);

                        IF EXTRACT(YEAR FROM expectedArrivalDateAux1) = EXTRACT(YEAR FROM SYSDATE) THEN

                            idleTime := idleTime + (phasesPerYear.expectedDepartureDate - expectedArrivalDateAux1);
                        ELSE
                            idleTime := idleTime + (phasesPerYear.expectedDepartureDate - to_date('01.01.'|EXTRACT(YEAR FROM SYSDATE)||'','DD.MM.YYYY'));
                        END IF;

                    END IF;

                    SELECT expectedArrivalDate INTO expectedArrivalDateAux
                    FROM Phases
                    WHERE id = phasesPerYear.id - 1
                    AND cargoManifestLoadId = cargoManifestsOfAShip
                    AND EXTRACT(YEAR FROM expectedArrivalDate) = EXTRACT(YEAR FROM SYSDATE);

                    idleTime := idleTime + (phasesPerYear.expectedDepartureDate - expectedArrivalDateAux);

                END LOOP;

            END LOOP;

            IF flag == false THEN

                SELECT COUNT(*) INTO allCml
                FROM CargoManifestLoad
                WHERE shipMmsiCode = allShipsMmsiCode
                AND isConcluded = 1;

                IF allCml == 0 THEN
                    outString := outString || 'The ship with the mmsi code: ' || allShipsMmsiCode || ', was idle for the entire year.' || chr(10);
                ELSE
                    outString := outString || 'The ship with the mmsi code: ' || allShipsMmsiCode || ', was not in idle in this year.' || chr(10);
                END IF;
            ELSE
                outString := outString || 'The ship with the mmsi code: ' || allShipsMmsiCode || ', was idle for : ' || idleTime ||' days.' ||  chr(10);
            END IF;

        END LOOP;


    END;