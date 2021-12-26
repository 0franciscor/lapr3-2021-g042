create or replace Trigger WarehouseOccupancy

Before Insert OR DELETE
ON CargoManifestContainer
FOR EACH ROW

DECLARE

dest INTEGER;
numerator INTEGER := 0;
lastDesiredCml INTEGER;
cmLoad INTEGER;
cmuCode Integer;
ocRate Float;
cap Integer;
destAux Varchar(255);
contAux integer;
flag Integer;
total Integer :=0;
tripAux integer;


    CURSOR cmu IS
    SELECT id
    FROM CargoManifestUnload
    WHERE CargoManifestUnload.WarehouseId=dest;

    BEGIN

    IF INSERTING THEN

        Select destination into destAux
        from Trip
        where id=:NEW.PhasesId AND cargoManifestLoadId=:NEW.cargoManifestLoadId;


    ELSE

        Select destination into destAux
        from Phases
        where id=:OLD.PhasesId AND cargoManifestLoadId=:OLD.cargoManifestLoadId;


    END IF;

    Select COUNT(*) into flag
        from Warehouse
        where name=destAux;

    IF flag!=0 THEN

        Select id into dest
        from Warehouse
        where name=destAux;
    OPEN cmu;
    LOOP
            FETCH cmu INTO cmuCode;
            EXIT WHEN cmu%notfound;

            dbms_output.put_line('cmu ' ||cmuCode);


            SELECT CargoManifestLoadId, PhasesId INTO cmLoad,tripAux
            FROM CargoManifestUnload
            WHERE warehouseId=dest AND id=cmuCode;

            dbms_output.put_line('cml ' ||cmLoad);


            For containers
            IN(SELECT ContainerNumberId, cargoManifestLoadId
            FROM CargoManifestContainer
            WHERE CargoManifestUnloadId=cmuCode AND CargoManifestLoadId=cmLoad AND PhasesId=tripAux)
            LOOP

                SELECT MAX(CargoManifestLoad.Id) INTO lastDesiredCml
                FROM CargoManifestContainer
                INNER JOIN CargoManifestLoad
                ON (CargoManifestLoad.id=CargoManifestContainer.cargoManifestLoadId)
                WHERE ContainerNumberId=containers.ContainerNumberId;

                dbms_output.put_line('ldcml ' ||lastDesiredcml);


                IF containers.CargoManifestLoadId=lastDesiredCml THEN
                    numerator:=numerator+1;
                END IF;

                END LOOP;
            END LOOP;

            select capacity into cap
            from warehouse
            where id=dest;


            /*select COUNT(*) into contAux
            from cargoManifest_Container
            where cargoManifestLoadId=:new.cargoManifestLoadId
            AND PhasesId=:new.PhasesId;

            total := total + contAux;*/


            FOR cml
            IN(SELECT id
            from cargoManifestLoad
            where isConcluded is null)
            LOOP
                FOR trips
                IN(SELECT id
                from Phases
                where cargoManifestLoadId=cml.id
                and destination=destAux)
                LOOP
                    SELECT COUNT(containerNumberId) INTO contAux
                    from cargoManifestContainer
                    where cargoManifestLoadId=cml.id
                    and PhasesId=Phases.Id;

                    total:=total+contAux;

                END LOOP;

            END LOOP;


            dbms_output.put_line('unloaded ' ||numerator);
            dbms_output.put_line('cap ' ||cap);
            dbms_output.put_line('total ' ||total);


            ocRate:=((numerator+total+1)/cap)*100;


            dbms_output.put_line('ocr ' ||ocRate);


            UPDATE Warehouse
            SET occupancy= ocRate
            where id=dest;
        END IF;

    END;