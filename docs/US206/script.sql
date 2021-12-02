CREATE OR REPLACE PROCEDURE US206 (mmsiCode in Varchar, outString out Varchar)
IS
    cmunload Integer;
    bool Boolean;
    Phases Integer;
    cmcode Integer;
    nextLocation varchar(255);
    cargoId Integer;
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
        
        SELECT COUNT(Phases.CargoManifestLoadid) INTO Phases 
        FROM Phases
        INNER JOIN CargoManifestLoad
        ON(CargoManifestLoad.id=Phases.CargoManifestLoadid)
        WHERE Phases.CargoManifestLoadid=cmcode;
        dbms_output.put_line(Phases);   

        SELECT COUNT(CargoManifestUnload.phasesCargoManifestLoadID) INTO cmunload 
        FROM CargoManifestUnload
        INNER JOIN CargoManifestLoad
        ON(CargoManifestUnload.PhasesCargoManifestLoadID=CargoManifestLoad.id)
        WHERE CargoManifestUnload.PhasesCargoManifestLoadID=cmcode;                                          
        dbms_output.put_line(cmunload);

        IF Phases=cmunload THEN
            dbms_output.put_line('Delivery finished: '||cmcode);
                
        ELSE
            SELECT destination INTO nextLocation
            FROM Phases                    
            WHERE id=cmunload+1
            AND CargoManifestLoadid=cmcode;
            dbms_output.put_line('Next port: '||nextLocation);
            
            FOR cmIds_wDesiredPhaseandOrigin 
            IN(SELECT Phases.CargoManifestLoadid 
            FROM Phases 
            INNER JOIN CargoManifestLoad 
            ON (Phases.CargoManifestLoadid=CargoManifestLoad.id)  
            WHERE Phases.origin = nextLocation 
            AND Phases.id=1 
            AND Phases.CargoManifestLoadid> cmcode
            AND CargoManifestLoad.ShipmmsiCode = mmsiCode)
            LOOP
                dbms_output.put_line('Cargo Manifest ID to load: ' ||cmIds_wDesiredPhaseandOrigin.cargomanifestloadid);
                outString:=outString || cmIds_wDesiredPhaseandOrigin.cargomanifestloadid || chr(10);
                For containers_fromLastLoop
                IN(select containernumberid 
                from CargoManifest_Container
                where cargomanifestid= cmIds_wDesiredPhaseandOrigin.cargomanifestloadid)
                LOOP
                    SELECT isoCode, weight INTO iso_type, weight_load FROM CONtainer WHERE numberId=containers_fromLastLoop.containernumberid;
                    dbms_output.put_line('Cargo Manifest of Containers to load: ' ||cmIds_wDesiredPhaseandOrigin.CargoManifestLoadid ||'Type: ' ||iso_type ||'Load: ' ||weight_load);
                    outString:=outString || 'Cargo Manifest of Containers to load: ' ||cmIds_wDesiredPhaseandOrigin.CargoManifestLoadid ||'Type: ' ||iso_type ||'Load: ' ||weight_load || chr(10);
                END LOOP;    
            END LOOP;
            EXIT;
        END IF;
    END LOOP;
    CLOSE cm;
END;