CREATE OR REPLACE PROCEDURE US208 (idCargoManifest in INTEGER, occupancyRate out FLOAT) IS

    totalContainers INTEGER;
    shipMmsiCode VARCHAR(255);
    capacityShip FLOAT;

BEGIN

    occupancyRate:=0;
    totalContainers:=0;

    SELECT COUNT (*) INTO totalContainers
    FROM CargoManifestContainer
    WHERE CargoManifestContainer.cargoManifestLoadId = idCargoManifest;

    SELECT shipMmsiCode INTO shipMmsiCode
    FROM CargoManifestLoad
    WHERE CargoManifestLoad.id = idCargoManifest;

    SELECT capacity INTO capacityShip
    FROM Ship
    WHERE Ship.mmsiCode = shipMmsiCode;

    occupancyRate:= (totalContainers/capacityShip)*100;

END;