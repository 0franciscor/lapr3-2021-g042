CREATE OR REPLACE PROCEDURE US208 (idCargoManifest in INTEGER, ratio out FLOAT) IS

    totalContainers INTEGER;
    mmsiCode VARCHAR(255);
    capacityShip FLOAT;

BEGIN

    ratio:=0;
    totalContainers:=0;

    SELECT COUNT (*) INTO totalContainers
    FROM CargoManifestContainer
    WHERE CargoManifestContainer.cargoManifestLoadId = idCargoManifest;

    SELECT shipMmsiCode INTO mmsiCode
    FROM CargoManifestLoad
    WHERE CargoManifestLoad.id = idCargoManifest;

    SELECT capacity INTO capacityShip
    FROM Ship
    WHERE Ship.mmsiCode = mmsicode;

    ratio:= totalContainers/capacityShip;

END;