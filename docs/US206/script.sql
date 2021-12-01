CREATE OR REPLACE PROCEDURE US206 (mmsiCode in Varchar, outString out Varchar)
IS
    cmunload Integer;
    bool Boolean;
    phases Integer;
    cmcode CargoManifestLoad.id%type;
    nextLocatiON Phases.origin%type;
    cargoId Integer;
    iso_type varchar(255);
    weight_load float;

CURSOR cm IS
        SELECT id
        FROM CargoManifestLoad
        WHERE Shipmmsicode=mmsiCode;

BEGIN
OPEN cm;
    LOOP 
        fetch cm INTO cmcode;
        Exit When cm%notfound;
        dbms_output.put_line('cargo id: ' ||cmcode);
        

        SELECT COUNT(Phases.CargoManifestLoadid) INTO phases 
        FROM Phases
        INNER JOIN CargoManifestLoad
        ON(CargoManifestLoad.ID=Phases.CargoManifestLoadid)
        WHERE Phases.CargoManifestLoadid=cmcode;
        dbms_output.put_line(phases);   

        SELECT COUNT(CARGOMANIFESTUNLOAD.PHASESCargoManifestLoadID) INTO cmunload 
        FROM CARGOMANIFESTUNLOAD
        INNER JOIN CargoManifestLoad
        ON(CARGOMANIFESTUNLOAD.PHASESCargoManifestLoadID=CargoManifestLoad.id)
        WHERE CARGOMANIFESTUNLOAD.PHASESCargoManifestLoadID=cmcode;                                          
        dbms_output.put_line(cmunload);

        IF phases=cmunload THEN
            dbms_output.put_line('Finalized cargo manifest id: '||cmcode);
                
        ELSE
            SELECT origin INTO nextLocatiON
            FROM Phases                    
            WHERE id=cmunload+1
            AND CargoManifestLoadid= cmcode;
            dbms_output.put_line('Next port: '||nextLocatiON);
            
            FOR teste 
            IN(SELECT Phases.CargoManifestLoadid 
            FROM Phases 
            INNER JOIN CargoManifestLoad 
            ON (Phases.CargoManifestLoadid=CargoManifestLoad.id)  
            WHERE Phases.origin = nextLocatiON 
            AND Phases.id=1 AND Phases.CargoManifestLoadid> 
            cmcode
            AND CargoManifestLoad.ShipmmsiCode = mmsiCode)
            LOOP
                SELECT isoCode, weight INTO iso_type, weight_load FROM CONtainer WHERE numberId=teste.CONtainerNumberId;
                dbms_output.put_line('Cargo Manifest of Containers to load: ' ||teste.CargoManifestLoadid ||'Type: ' ||iso_type ||'Load: ' ||weight_load);
                outString:=outString || 'Cargo Manifest of Containers to load: ' ||teste.CargoManifestLoadid ||'Type: ' ||iso_type ||'Load: ' ||weight_load || chr(10);
            END LOOP;
                
        END IF;
        
    END LOOP;
    CLOSE cm;
END;
