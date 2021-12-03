CREATE OR REPLACE PROCEDURE US206 (mmsiCode in Varchar, outString out Varchar)
IS
    cmload Integer;
    Phases Integer;
    cmcode Integer;
    cargoId Integer;
    nextLocation varchar(255);
    iso_type varchar(255);
    weight_load float;

CURSOR cm IS
    SELECT id
    FROM CargoManifestLoad
    WHERE Shipmmsicode=mmsiCode
    ORDER BY id;

BEGIN
    OPEN cm;
        LOOP 
            fetch cm INTO cmcode;
            Exit When cm%notfound;
            dbms_output.put_line('Cargo Manifest ID: ' ||cmcode);
            
            SELECT COUNT(Phases.CargoManifestLoadId) INTO Phases 
            FROM Phases
            WHERE Phases.CargoManifestLoadId=cmcode;
            dbms_output.put_line(Phases); 

            SELECT COUNT(CargoManifestLoad.id) INTO cmload
            FROM CargoManifestLoad
            WHERE CargoManifestLoad.id=cmcode;
            dbms_output.put_line(cmload);

            IF Phases!=cmload THEN  
                SELECT destination INTO nextLocation
                FROM Phases                    
                WHERE id=cmload+1
                AND CargoManifestLoadId=cmcode;
                dbms_output.put_line('Next port: '|| nextLocation);

                SELECT Phases.CargoManifestLoadId INTO cmGeneratedLoad
                FROM Phases 
                INNER JOIN CargoManifestLoad 
                ON (Phases.CargoManifestLoadId=CargoManifestLoad.id) 
                WHERE Phases.origin=nextLocation
                AND Phases.id=1 AND Phases.CargoManifestLoadId>cmcode AND CargoManifestLoad.ShipmmsiCode=mmsiCode
                For containers_from_cm_generatedLoad
                IN(select ContainerNumberId FROM CargoManifestContainer WHERE CargoManifestLoadId=cmGeneratedLoad.cargomanifestloadid)
                LOOP
                    SELECT isoCode, weight INTO iso_type, weight_load FROM Container WHERE numberId=containers_from_cm_generatedLoad.ContainerNumberId;
                    outString:=outString || 'Cargo Manifest of Containers to load: ' ||cmGeneratedLoad.CargoManifestLoadId ||'Type: ' ||iso_type ||'Load: ' ||weight_load || chr(10);
                END LOOP;
                EXIT;
            END IF;
        END LOOP;
    CLOSE cm;
END;