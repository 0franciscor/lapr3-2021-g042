CREATE OR REPLACE PROCEDURE resourcesForNextWeek(idOfAPort IN INTEGER, outString OUT VARCHAR2) IS

    nextSunday DATE;
    nextMonday DATE;
    cml INTEGER;
    portName VARCHAR(255);
    containersDeparting INTEGER;
    containersArriving INTEGER;

    CURSOR cargoManifestsLoad IS
    SELECT id
    FROM CargoManifestLoad
    INNER JOIN Phases
    ON (cargoManifestLoad.Id = Phases.CargoManifestLoadId)
    WHERE expectedArrivalDate <= nextSunday
    AND expectedArrivalDate >= nextMonday;

    BEGIN
         SELECT NEXT_DAY(sysdate,'Segunda') INTO nextMonday FROM DUAL;
         SELECT NEXT_DAY(nextMonday,'Domingo') INTO nextSunday FROM DUAL;



        OPEN cargoManifestsLoad;
        LOOP
            FETCH cargoManifestsLoad INTO cml;
            EXIT WHEN cargoManifestsLoad%notFound;

            SELECT name INTO portName FROM Ports WHERE id = idOfAPort;

            outString := outString || 'In the port with the name ' || portName || ' in the week of ' || nextMonday || ' until ' || nextSunday || ': ' || chr(10);

            FOR phasesInACargoManifest IN
            (SELECT origin, destination, id
            FROM Phases
            WHERE cargoManifestLoadId = cml)
            LOOP
                IF phasesInACargoManifest.destination = portName THEN

                    SELECT COUNT(*) INTO containersArriving
                    FROM CargoManifestContainer
                    WHERE cargoManifestLoadId = cml
                    AND phasesId = phasesInACargoManifest.id;

                    outString := outString || containersArriving || 'containers arrived.' || chr(10);
                    outString := outString || 'the containers are as follows: ' || chr(10);

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

                    outString := outString || containersDeparting || 'containers left.' || chr(10);
                    outString := outString || 'the containers are as follows: ' || chr(10);

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

        END LOOP;






