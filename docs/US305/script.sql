CREATE OR REPLACE PROCEDURE US305 (registrationCode in Varchar, outString out Varchar)
IS
    registrationCode Integer;
    cmcode Integer;
    exitPhase Integer;
    meanOfTransport Integer;

CURSOR cm IS
    SELECT id
    FROM CargoManifestLoad
    INNER JOIN CargoManifestContainer
    ON (CargoManifestContainer.CargoManifestLoadId=CargoManifestLoad.id)
    WHERE CargoManifestContainer.ContainernumberId=registrationCode
    ORDER BY id;

BEGIN
    OPEN cm;
    LOOP   
        fetch cm INTO cmcode;
        Exit WHEN cm%notfound;

        SELECT PhasesId INTO exitPhase
        FROM CargoManifestContainer
        WHERE cargoManifestLoadId=cmcode AND containerNumberId=registrationCode;

        SELECT portId INTO meanOfTransport
        FROM CargoManifestLoad
        WHERE cargoManifestLoadId=cmcode;

        For par_of_ports   
        IN (SELECT id, origin, destination, realDepartureDate, realArrivalDate FROM Phases WHERE CargoManifestLoadId=cmcode) 
        LOOP
        IF exitPhase<=par_of_ports.id THEN 
            outString:=outString || par_of_ports.origin || ',' || par_of_ports.realDepartureDate || ';' || par_of_ports.destination || ',' || par_of_ports.realArrivalDate || chr(10);
            IF meanOfTransport IS NOT NULL THEN
                outString:=outString || "Mean of transport: Ship" || chr(10);
            ELSE IF meanOfTransport IS NULL THEN   
                outString:=outString || "Mean of transport: Truck" || chr(10);
            END IF;
        END IF;
        END LOOP;
    END LOOP;
    CLOSE cm;
END;


