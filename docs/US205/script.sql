CREATE OR REPLACE PROCEDURE US205 (mmsiCode in Varchar, outString out Varchar)
IS
    cmunload Integer;
    bool Boolean;
    phases Integer;
    cmcode CargoManifestLoad.id%type;
    nextLocation Phases.origin%type;
    x Integer;
    y Integer;
    z Integer;
    iso_type varChar (255);
    weight_load float;
    nextPort Varchar (255);
    proxLoc Varchar (255);

Cursor cm IS
    SELECT id
    FROM cargomanifestload
    WHERE Shipmmsicode=mmsiCode 
    ORDER BY id;

BEGIN
OPEN cm;
    LOOP 
        FETCH cm INTO cmcode;
        Exit WHEN cm%notfound;
        dbms_output.put_line('Cargo Manifest id: ' ||cmcode);
        

        SELECT COUNT(Phases.CargoManifestLoadid) INTO phases 
        FROM Phases
        INNER JOIN CARGOMANIFESTLOAD
        ON(CARGOMANIFESTLOAD.ID=Phases.CargoManifestLoadid)
        WHERE Phases.CargoManifestLoadid = cmcode;
        
        dbms_output.put_line(phases);    

        SELECT COUNT(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID) INTO cmunload 
        FROM CARGOMANIFESTUNLOAD
        INNER JOIN CARGOMANIFESTLOAD
        ON(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID=CARGOMANIFESTLOAD.id)
        WHERE CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID=cmcode;                                          
        dbms_output.put_line(cmunload);

        IF phases = cmunload THEN
            dbms_output.put_line('Delivery finished ' ||cmcode);
                
        ELSE
            SELECT destination INTO proxLoc
            FROM phases                    
            WHERE id=cmunload+1
            AND cargomanifestloadid= cargoscode;
            dbms_output.put_line('Next Port: ' ||proxLoc);
            
            contador:= contador + 1;
            
            IF contador=1 THEN
                nextPort:= proxLoc;
            End IF;
            
            IF proxLoc=nextPort THEN
            
                FOR containers_toExitInDestination 
                IN(Select cargomanifest_container.containernumberid 
                    FROM cargomanifest_container 
                    INNER JOIN phases
                    ON(cargomanifest_container.cargomanifestid = phases.cargomanifestloadid)
                    WHERE cargomanifest_container.cargomanifestid=cargoscode 
                    AND cargomanifest_container.completedphase= cmunload+1
                    AND phases.destination= proxLoc)
                LOOP
                    SELECT xContainer, yContainer, zContainer INTO x, y, z FROM CargoManifestContainer WHERE numberId=containers_toExitInDestination.containerNumberId;
                    SELECT isoCode, weight INTO iso_type, weight_load FROM Container WHERE numberId=containers_toExitInDestination.containerNumberId;
                    dbms_output.put_line('Container Number Id: ' ||containers_toExitInDestination.containernumberid || 'Positions:' ||x ||y ||z ||'Type: ' ||iso_type ||'Load: ' ||weight_load);
                    outString:=outString || 'Container Number Id: ' ||containers_toExitInDestination.containernumberid || 'Positions:' ||x ||y ||z ||'Type: ' ||iso_type ||'Load: ' ||weight_load || chr(10);
                END LOOP;
            END IF;
        END IF;
    END LOOP;
    CLOSE cm;
END;

