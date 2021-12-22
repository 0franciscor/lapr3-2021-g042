CREATE OR REPLACE Trigger US309

Before Insert
ON CargoManifestContainer
FOR EACH ROW

DECLARE

cmcode INTEGER;
realDepDate DATE;
realArrDate DATE;

CURSOR cm IS
SELECT id
FROM CargoManifestLoad
WHERE CargoManifestLoad.isConcluded IS NULL AND shipMmsiCode = (SELECT shipMmsiCode FROM CargoManifestLoad WHERE id=:NEW.CargoManifestLoadId);


BEGIN
    OPEN cm;
    LOOP
    FETCH cm INTO cmcode;
    EXIT WHEN cm%notfound;
        FOR seeDatePhases
        IN ( SELECT realDepartureDate, realArrivalDate FROM Phases WHERE CargoManifestLoadId = cmcode )
        LOOP        
        IF SYSDATE >= seeDatePhases.realDepartureDate OR SYSDATE <= seeDatePhases.realArrivalDate THEN
            raise_application_error( -21000, 'Cargo Manifest registration ERROR');
        END IF;
        END LOOP;
    END LOOP;
    CLOSE CM; 
END;