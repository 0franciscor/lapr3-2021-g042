Declare
    cmunload Integer;
    bool Boolean;
    cmload Integer;
    cmcode CargoManifestLoad.id%type;
    nextLocatiON Phases.origin%type;
    x Integer;
    y Integer;
    z Integer;
    iso_type varChar;
    weight_load float;

Cursor cargos IS
    SELECT id
    FROM cargomanifestload
    WHERE shipmmsicode='683407693';

BEGIN
OPEN cargos;
    LOOP 
        FETCH cargos INTO cmcode;
        Exit WHEN cargos%notfound;
        dbms_output.put_line('Cargo Manifest id: ' ||cmcode);
        SELECT Count(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID) INTO cmunload 
                FROM CARGOMANIFESTUNLOAD
                INNER JOIN CARGOMANIFESTLOAD
                ON(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID= CARGOMANIFESTLOAD.id)
                WHERE CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID = cmcode;                                          
    
                dbms_output.put_line(cmunload);
    
                SELECT COUNT(Phases.CargoManifestLoadid) INTO cmload 
                FROM Phases
                INNER JOIN CARGOMANIFESTLOAD
                ON(CARGOMANIFESTLOAD.ID=Phases.CargoManifestLoadid)
                WHERE Phases.CargoManifestLoadid = cmcode;
                
                dbms_output.put_line(cmload);    
                
                IF cmload= cmunload THEN
                        dbms_output.put_line('Cargo Manifest finalized id: ' ||cmcode);
                        
                ELSE
                    SELECT origin INTO nextLocatiON
                    FROM Phases                    
                    WHERE id=cmunload+1
                    AND CargoManifestLoadid= cmcode;
                    dbms_output.put_line('Next port: ' ||nextLocatiON);
                    FOR teste 
                    IN(SELECT cONtainernumberid FROM CargoManifestCONtainer WHERE CargoManifestCONtainer.cargomanifestid=cmcode AND COMPLETEDPHASE=cmunload+1)
                    LOOP
                        SELECT xCONtainer, yCONtainer, zCONtainer INTO x, y, z FROM CargoManifestCONtainer WHERE numberId=teste.cONtainerNumberId;
                        SELECT isoCode, weight INTO iso_type, weight_load FROM CONtainer WHERE numberId=teste.cONtainerNumberId;
                        dbms_output.put_line('Container Number Id: ' ||teste.cONtainernumberid || 'PositiONs:' ||x ||y ||z ||'Type: ' ||iso_type ||'Load: ' ||weight_load);
                    END LOOP;
                
                END IF;
                
            END LOOP;
END;