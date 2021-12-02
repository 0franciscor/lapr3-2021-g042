CREATE OR REPLACE PROCEDURE US209 (mmsiCodeShip in VARCHAR(255), actualDate in DATE, occupancyRate out FLOAT) IS

    totalContainers INTEGER;
    capacityShip FLOAT;
    cargoManifestsId CargoManifestLoad.Id%type;
    date1 DATE;
    cont INTEGER;
    flag BOOLEAN;

    CURSOR cargoManifests
    SELECT id
    FROM CargoManifestLoad
    WHERE shipMmsiCode = mmsiCodeShip;

BEGIN

    occupancyRate:=0;
    totalContainers:=0;
    OPEN cargoManifests;

    LOOP
        FETCH cargoManifests INTO cargoManifestsId;
        EXIT WHEN cargoManifests%NOTFOUND;

        SELECT COUNT (*) INTO contPhases


        FOR phasesInCargoManifest IN
        (SELECT Phases.id
        FROM Phases
        WHERE Phases.cargoManifestLoadId = cargoManifestsId)
        LOOP
            SELECT realDepartureDate, realArrivalDate, id INTO date1, date2, idOfPhase
            FROM Phases
            WHERE Phases.id = phasesInCargoManifest.id
            AND cargoManifestLoadId = cargoManifestsId;

            IF (date1 < actualDate AND date2 > actualDate) THEN
                SELECT COUNT (*) INTO totalContainers
                FROM CargoManifestContainer
                WHERE phasesId = idOfPhase
                AND cargoManifestLoadId = cargoManifestsId;
                flag := true;
                EXIT;
            END IF;
        END LOOP;

        IF flag = true THEN
        EXIT;
        END IF;
    END LOOP;

    SELECT capacity INTO capacityShip
    FROM Ship
    WHERE Ship.mmsiCode = mmsiCodeShip;

    occupancyRate:= (totalContainers/capacityShip)*100;

END;