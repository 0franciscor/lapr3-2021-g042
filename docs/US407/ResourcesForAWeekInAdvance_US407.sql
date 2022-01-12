CREATE OR REPLACE PROCEDURE resourcesForNextWeek(idOfAPort IN INTEGER, outString OUT VARCHAR2) IS

    nextSunday DATE;
    nextSaturday DATE;
    cml INTEGER;
    portName VARCHAR(255);
    containersDeparting INTEGER;
    containersArriving INTEGER;
    containersDepartingAux INTEGER := 0;
    containersArrivingAux INTEGER := 0;


    CURSOR cargoManifestsLoad IS
    SELECT cargoManifestLoad.id
    FROM CargoManifestLoad
    INNER JOIN Phases
    ON (cargoManifestLoad.Id = Phases.CargoManifestLoadId)
    WHERE expectedArrivalDate <= nextSaturday
    AND expectedArrivalDate >= nextSunday;

    BEGIN
        SELECT NEXT_DAY(sysdate,'Domingo') INTO nextSunday FROM DUAL;
        SELECT NEXT_DAY(nextSunday,'Sábado') INTO nextSaturday FROM DUAL;

        SELECT name INTO portName FROM Ports WHERE id = idOfAPort;
        outString := outString || 'In the port with the name ' || portName || ' in the week of ' || nextsunday || ' until ' || nextsaturday || ': ' || chr(10);

        FOR loopAux IN (EXTRACT (DAY FROM nextSunday))..(EXTRACT (DAY FROM nextSaturday))
        LOOP

            OPEN cargoManifestsLoad;
            LOOP
                FETCH cargoManifestsLoad INTO cml;
                EXIT WHEN cargoManifestsLoad%notFound;

                FOR phasesInACargoManifest IN
                (SELECT origin, destination, id, expectedArrivalDate, expectedDepartureDate
                FROM Phases
                WHERE cargoManifestLoadId = cml
                AND (EXTRACT (DAY FROM expectedArrivalDate) = loopAux
                OR EXTRACT (DAY FROM expectedDepartureDate) = loopAux))
                LOOP
                    IF phasesInACargoManifest.destination = portName THEN

                        SELECT COUNT(*) INTO containersArriving
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id;

                        containersArrivingAux := containersArrivingAux + containersArriving;

                        FOR allContainersArriving IN
                        (SELECT containerNumberId
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id)
                        LOOP
                            outString := outString || 'Container number id: ' || allContainersArriving.containerNumberId || ' (Arrival)' || chr(10);
                        END LOOP;
                    END IF;

                    IF phasesInACargoManifest.origin = portName THEN

                        SELECT COUNT(*) INTO containersDeparting
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id;

                        containersDepartingAux := containersDepartingAux + containersDeparting;

                        FOR allContainersDeparting IN
                        (SELECT containerNumberId
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id)
                        LOOP
                            outString := outString || 'Container number id: ' || allContainersDeparting.containerNumberid || ' (Departure)' || chr(10);
                        END LOOP;
                    END IF;

                END LOOP;

            END LOOP;
            containersDepartingAux := 0;
            containersArrivingAux := 0;
            outString := outString || 'The total containers who arrived was: '|| containersArrivingAux || chr(10);
            outString := outString || 'The total containers who left was: ' || containersDepartingAux || chr(10);

        END LOOP;

    END;





