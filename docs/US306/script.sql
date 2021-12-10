CREATE OR REPLACE PROCEDURE US306 (outString out Varchar) IS

storehouse INTEGER;
cmucode INTEGER;
cmload INTEGER;
numerator INTEGER;
operation FLOAT;
capacity INTEGER;
expectedDepDate TIMESTAMP;
lastDesiredcml INTEGER;
finalDepDate DATE;

CURSOR warehouses IS
    SELECT id
    FROM warehouse;

CURSOR cmu IS
    SELECT id 
    FROM CargoManifestUnload
    WHERE CargoManifestUnload.warehouseid=warehouse;

BEGIN
    finalDepDate:=sysdate+30;
    OPEN warehouses;
    LOOP
        FETCH warehouses INTO storehouse
        EXIT WHEN warehouses%notfound;
        numerator:=0;

        outString:=outString || ' Warehouse: ' || storehouse || chr(10);
        outString:=outString || ' List of containers leaving the warehouse during the next 30 days: ' || chr(10);
        outString:=outString || ' Current Day ' || sysdate || chr(10);

        LOOP
            FETCH cmu INTO cmucode
            EXIT WHEN cmu%notfound;

            SELECT PhasesCargoManifestLoadId INTO cmload
            FROM CargoManifestUnload
            WHERE warehouseid=storehouse AND id=cmucode;

            For containers
            IN(SELECT ContainernumberId, cargoManifestLoadId
            FROM CargoManifestContainer
            WHERE CargoManifestUnloadId=cmucode AND CargoManifestLoadId=cmload)
            LOOP
                SELECT MAX(CargoManifestContainer.cargoManifestLoadId) INTO lastDesiredcml
                FROM CargoManifestContainer 
                INNER JOIN CargoManifestLoad
                ON (CargoManifestLoad.id=CargoManifestContainer.cargoManifestLoadId)
                WHERE ContainernumberId=containers.ContainernumberId AND CargoManifestLoad.isConcluded=1;

                IF containers.CargoManifestLoadId=lastDesiredcml THEN
                    numerator:=numerator+1;

                    SELECT expectedDepartureDate INTO expectedDepDate
                    FROM Phases
                    INNER JOIN CargoManifestContainer
                    ON (Phases.cargoManifestLoadId=CargoManifestContainer.cargoManifestLoadId)
                    WHERE CargoManifestContainer.containerNumberId=containers.containerNumberId
                    AND Phases.CargoManifestLoadId=lastDesiredcml+1);

                    IF expectedDepDate<=finalDepDate THEN
                        outString:=outString || 'Container: ' || containers.ContainernumberId || ' Expected Departure Date ' || expectedDepDate || chr(10);
                    END IF;

                END IF;

            END LOOP;
        END LOOP;

        SELECT warehousecapacity INTO capacity
        FROM warehouse
        WHERE id=storehouse;

        operation:=numerator/capacity;
        outString:=outString || ' Occupancy rate: ' || operation || chr(10);

    END LOOP;
END;