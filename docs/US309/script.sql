CREATE OR REPLACE Trigger US309

Before Insert
ON CargoManifestContainer
FOR EACH ROW

DECLARE

cmCode INTEGER;
realDepDate DATE;
realArrDate DATE;

CURSOR cm IS
SELECT id
FROM CargoManifestLoad
WHERE CargoManifestLoad.isConcluded IS NULL AND shipMmsiCode = (SELECT shipMmsiCode FROM CargoManifestLoad WHERE id=:NEW.CargoManifestLoadId);


BEGIN
    OPEN cm;
    LOOP
    FETCH cm INTO cmCode;
    EXIT WHEN cm%notfound;
        FOR seeDatePhases
        IN (SELECT realDepartureDate, realArrivalDate FROM Phases WHERE CargoManifestLoadId = cmCode)
        LOOP        
        IF SYSDATE >= seeDatePhases.realDepartureDate OR SYSDATE <= seeDatePhases.realArrivalDate THEN
            raise_application_error( -21000, 'Cargo Manifest registration ERROR');
        END IF;
        END LOOP;
    END LOOP;
    CLOSE CM; 
END;