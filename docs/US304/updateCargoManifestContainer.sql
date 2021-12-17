CREATE OR REPLACE PROCEDURE UpdateCargoManifestContainer(cnId in INTEGER, cmlId in INTEGER, cp in INTEGER, x in INTEGER, y in INTEGER, z in INTEGER, gross in FLOAT, pId in INTEGER, pcmlId in INTEGER, cmuId in INTEGER, userResp in VARCHAR)
IS

BEGIN

INSERT INTO CargoManifestContainer(containerNumberId, cargoManifestLoadId, completedPhase, xContainer, yContainer, zContainer, grossContainer, PhasesId, PhasesCargoManifestLoadId, CargoManifestUnloadId, userResponsibleForChanges)
VALUES(cnId, cmlId, cp, x, y, z, gross, pId, pcmlId, cmuId, userResp);

END;