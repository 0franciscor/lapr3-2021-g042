CREATE OR REPLACE PROCEDURE US205 (mmsiCode in Varchar, outString out Varchar)
IS
    cmunload Integer;
    phases Integer;
    cmcode Integer;
    x Integer;
    y Integer;
    z Integer;
    port_counter Integer :=0;
    nextLocation varchar(255);
    iso_type varChar (255);
    nextPort Varchar (255);
    proxLoc Varchar (255);
    weight_load float;

Cursor cm IS
    SELECT id
    FROM CargoManifestLoad
    WHERE Shipmmsicode=mmsiCode 
    ORDER BY id;

BEGIN
OPEN cm;
    LOOP 
        FETCH cm INTO cmcode;
        Exit WHEN cm%notfound;
        dbms_output.put_line('Cargo Manifest id: ' || cmcode);
        

        SELECT COUNT(Phases.CargoManifestLoadId) INTO phases 
        FROM Phases
        WHERE Phases.CargoManifestLoadid = cmcode;
        dbms_output.put_line(phases);    

        SELECT COUNT(CargoManifestUnload.PhasesCargoManifestLoadId) INTO cmunload 
        FROM CargoManifestUnload
        WHERE CargoManifestUnload.PhasesCargoManifestLoadId=cmcode;                                          
        dbms_output.put_line(cmunload);

        IF phases = cmunload THEN
            dbms_output.put_line('Delivery finished ' ||cmcode);
                
        ELSE
            SELECT destination INTO proxLoc
            FROM phases                    
            WHERE id=cmunload+1
            AND CargoManifestLoadid= cmcode;
            dbms_output.put_line('Next Port: ' ||proxLoc);
            
            port_counter:= port_counter + 1;
            
            IF port_counter=1 THEN
                nextPort:= proxLoc;
            End IF;
            
            IF proxLoc=nextPort THEN
                FOR containers_toExitInDestination 
                IN(Select CargoManifestContainer.ContainerNumberId 
                    FROM CargoManifestContainer 
                    INNER JOIN Phases
                    ON(CargoManifestContainer.CargoManifestLoadId = Phases.CargoManifestLoadId)
                    WHERE CargoManifestContainer.CargoManifestLoadid=cmcode 
                    AND CargoManifestContainer.Phases=cmunload+1
                    AND Phases.destination=proxLoc)
                LOOP
                    SELECT xContainer, yContainer, zContainer INTO x, y, z FROM CargoManifestContainer WHERE ContainernumberId=containers_toExitInDestination.containerNumberId;
                    SELECT isoCode, weight INTO iso_type, weight_load FROM Container WHERE numberId=containers_toExitInDestination.containerNumberId;
                    dbms_output.put_line('Container Number Id: ' ||containers_toExitInDestination.containernumberid || 'Positions:' ||x ||y ||z ||'Type: ' ||iso_type ||'Load: ' ||weight_load);
                    outString:=outString||'Container Number Id: '||containers_toExitInDestination.containernumberid||'Positions:'||x||y||z||'Type: '||iso_type||'Load:'||weight_load||chr(10);
                END LOOP;
            END IF;
        END IF;
    END LOOP;
    CLOSE cm;
END;



