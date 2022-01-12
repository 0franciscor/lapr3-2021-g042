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
    SELECT id
    FROM CargoManifestLoad
    INNER JOIN Phases
    ON (cargoManifestLoad.Id = Phases.CargoManifestLoadId)
    WHERE expectedArrivalDate <= nextSunday
    AND expectedArrivalDate >= nextMonday;

    BEGIN
         SELECT NEXT_DAY(sysdate,'Domingo') INTO nextSunday FROM DUAL;
         SELECT NEXT_DAY(nextSunday,'Sábado') INTO nextSaturday FROM DUAL;

        OPEN cargoManifestsLoad;

        LOOP
            FETCH cargoManifestsLoad INTO cml;
            EXIT WHEN cargoManifestsLoad%notFound;

            SELECT name INTO portName FROM Ports WHERE id = idOfAPort;

            outString := outString || 'In the port with the name ' || portName || ' in the week of ' || nextMonday || ' until ' || nextSunday || ': ' || chr(10);
            FOR loopAux IN EXTRACT DAY FROM (nextSunday)...EXTRACT DAY FROM (nextSaturday)
            LOOP
                FOR phasesInACargoManifest IN
                (SELECT origin, destination, id, expectedArrivalDate, expectedDepartureDate
                FROM Phases
                WHERE cargoManifestLoadId = cml
                AND (EXTRACT DAY FROM (expectedArrivalDate) = loopAux
                OR EXTRACT DAY FROM (expectedDepartureDateDate) = loopAux))
                LOOP
                    IF phasesInACargoManifest.destination = portName THEN

                        SELECT COUNT(*) INTO containersArriving
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id;

                        containersArrivingAux := containersArrivingAux + containersArriving;

                        outString := outString || 'The containers who arrived was in the day ' || loopAux || ' was:' || chr(10);

                        FOR allContainersArriving IN
                        (SELECT containerNumberId
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id)
                        LOOP
                            outString := outString || 'Container number id: ' || allContainersArriving.id || chr(10);
                        END LOOP;
                    END IF;

                    IF phasesInACargoManifest.origin = portName THEN

                        SELECT COUNT(*) INTO containersDeparting
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id;

                        containersDepartingAux := containersDepartingAux + containersDeparting;

                        outString := outString || 'The containers who departure in the day ' || loopAux || ' was:' || chr(10);

                        FOR allContainersDeparting IN
                        (SELECT containerNumberId
                        FROM CargoManifestContainer
                        WHERE cargoManifestLoadId = cml
                        AND phasesId = phasesInACargoManifest.id)
                        LOOP
                            outString := outString || 'Container number id: ' || allContainersDeparting.id || chr(10);
                        END LOOP;
                    END IF;

                END LOOP;
                outString := outString || 'The total containers who arrived was: '|| containersArrivingAux || chr(10);
                outString := outString || 'The total containers who left was: ' || containersDepartingAux || chr(10);
            END LOOP;


        END LOOP;






