CREATE OR REPLACE PROCEDURE US206 (mmsiCode in Varchar, outString out Varchar)
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

Cursor cm IS
    SELECT id
    FROM cargomanifestload
    WHERE Shipmmsicode=mmsiCode;

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

        SELECT Count(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID) INTO cmunload 
        FROM CARGOMANIFESTUNLOAD
        INNER JOIN CARGOMANIFESTLOAD
        on(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID= CARGOMANIFESTLOAD.id)
        WHERE CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID = cmcode;                                          

        dbms_output.put_line(cmunload);

        IF phases = cmunload THEN
            dbms_output.put_line('Cargo Manifest finalized id: ' ||cmcode);
                
        ELSE
            SELECT origin INTO nextLocation
            FROM Phases                    
            WHERE id=cmunload+1
            AND CargoManifestLoadid= cmcode;
            dbms_output.put_line('Next port: ' ||nextLocation);
            FOR teste 
            IN(SELECT containernumberid FROM CargoManifestContainer WHERE CargoManifestContainer.cargomanifestid=cmcode AND COMPLETEDPHASE=cmunload+1)
            LOOP
                SELECT xContainer, yContainer, zContainer INTO x, y, z FROM CargoManifestContainer WHERE numberId=teste.containerNumberId;
                SELECT isoCode, weight INTO iso_type, weight_load FROM Container WHERE numberId=teste.containerNumberId;
                dbms_output.put_line('Container Number Id: ' ||teste.containernumberid || 'Positions:' ||x ||y ||z ||'Type: ' ||iso_type ||'Load: ' ||weight_load);
                outString:=outString || 'Container Number Id: ' ||teste.containernumberid || 'Positions:' ||x ||y ||z ||'Type: ' ||iso_type ||'Load: ' ||weight_load || chr(10);
            END LOOP;
        
        END IF;
        
    END LOOP;
    CLOSE cm;
END;