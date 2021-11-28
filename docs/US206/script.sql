select containernumberid
from CargoManifestContainer
where CargoManifestid= (select CargoManifestLoad.id 
                        from CargoManifestLoad
                        INNER JOIN Phases
                        ON (Phases.CargoManifestLoadId=CargoManifestLoad.id)
                        WHERE CargoManifestLoad.ShipmmsiCode='123456789'
                        AND Phases.origin='Porto'
                        AND Phases.id=1);