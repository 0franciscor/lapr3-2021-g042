CREATE OR REPLACE TRIGGER WarehouseOccupancy

BEFORE INSERT OR DELETE
ON CargoManifestContainer
FOR EACH ROW

DECLARE

destinations INTEGER;
numerator INTEGER := 0;
lastDesiredCml INTEGER;
cmLoad INTEGER;
cmuCode INTEGER;
ocRate FLOAT;
cap INTEGER;
destinationAux VARCHAR(255);
contAux INTEGER;
flag INTEGER;


CURSOR cmu IS
    SELECT id
    FROM CargoManifestUnload
    WHERE CargoManifestUnload.warehouseId=destinations;

    BEGIN

    
    IF INSERTING THEN

        SELECT destination INTO destinationAux
        FROM Phases
        WHERE id=:NEW.PhasesId AND cargoManifestLoadId=:NEW.CargoManifestLoadId;


       
    ELSE

        SELECT destination INTO destinationAux
        FROM Phases
        WHERE id=:OLD.PhasesId AND cargoManifestLoadId=:OLD.cargoManifestLoadId;


    END IF;
    
    SELECT COUNT(*) INTO flag
        FROM Warehouse
        WHERE name=destinationAux;
        
        
    IF flag !=0 THEN
    
    SELECT id INTO destinations
        FROM Warehouse
        WHERE name=destinationAux;
    dbms_output.put_line('entrou' );
    OPEN cmu;
    LOOP
            FETCH cmu INTO cmuCode;
            EXIT WHEN cmu%notfound;


            SELECT phasesCargoManifestLoadId INTO cmLoad
            FROM CargoManifestUnload
            WHERE warehouseId=destinations AND id=cmuCode;

            FOR containers
            IN(SELECT ContainerNumberId, cargoManifestLoadId
            FROM CargoManifestContainer
            WHERE CargoManifestUnloadId=cmuCode AND CargoManifestLoadId=cmLoad)
            LOOP
                SELECT MAX(CargoManifestLoad.Id) INTO lastDesiredCml
                FROM CargoManifestContainer
                INNER JOIN CargoManifestLoad
                ON (CargoManifestLoad.id=CargoManifestContainer.cargoManifestLoadId)
                WHERE ContainerNumberId=containers.ContainerNumberId AND CargoManifestLoad.isConcluded=1;

                IF containers.CargoManifestLoadId=lastDesiredCml THEN
                    numerator:=numerator+1;
                END IF;

                END LOOP;
            END LOOP;

            SELECT capacity INTO cap
            FROM warehouse
            WHERE id=destinations;


            SELECT COUNT(*) INTO contAux
            FROM cargoManifestContainer
            WHERE cargoManifestLoadId=:new.cargoManifestLoadId
            AND PhasesId=:new.PhasesId;

            dbms_output.put_line('ocr ' ||cap);
            dbms_output.put_line('ocr ' ||numerator);
            dbms_output.put_line('contAux ' ||contAux);


            -- +1 por ser before, entao precisamos acrescentar o atual--
            ocRate:=((numerator+contAux+1)/cap)*100;


            dbms_output.put_line('ocr ' ||ocRate);


            UPDATE Warehouse
            SET occupancy = ocRate
            WHERE id = destinations;

        END IF;

 END;