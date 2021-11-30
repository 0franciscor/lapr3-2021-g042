CREATE OR REPLACE PROCEDURE US208 (idCargoManifest in INTEGER, actualDate in DATE, occupancyRate out FLOAT) IS

    totalContainers INTEGER;
    shipMmsiCode VARCHAR(255);
    capacityShip FLOAT;
    idOfPhase CargoManifestContainer.phasesId%type;
    date1 DATE;
    cont INTEGER;

    CURSOR cmContainer
    SELECT phasesId
    FROM CargoManifestContainer
    WHERE cargoManifestLoadId = idCargoManifest;

BEGIN

    occupancyRate:=0;
    totalContainers:=0;
    OPEN cmContainer;

    LOOP
        FETCH cmContainer INTO idOfPhase;
        EXIT WHEN cmContainer%NOTFOUND;

        SELECT realDepartureDate INTO date1
        FROM Phases
        WHERE Phases.id = idOfPhase;

        SELECT realArrivalDate INTO date2
        FROM Phases
        WHERE Phases.id = idOfPhase;

        IF (date1 < actualDate AND date2 = NULL) THEN
            totalContainers := totalContainers + 1;
        END IF;
    END LOOP;

    SELECT shipMmsiCode INTO shipMmsiCode
    FROM CargoManifestLoad
    WHERE CargoManifestLoad.id = idCargoManifest;

    SELECT capacity INTO capacityShip
    FROM Ship
    WHERE Ship.mmsiCode = shipMmsiCode;

    occupancyRate:= (totalContainers/capacityShip)*100;

END;