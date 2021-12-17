CREATE OR REPLACE FUNCTION getInformationAboutAuditTrails(cargoManifestId INTEGER, containerId INTEGER) RETURN VARCHAR2
IS
    opName VARCHAR(6);
    out VARCHAR2(2555);

BEGIN
    FOR getInformation
    IN (SELECT userUserName, operationsId, cargoManifestContainerNumberId, cargoManifestContainerCargoManifestLoadId, id,dateOfChange
    FROM AuditTrails
    WHERE cargoManifestContainerCargoManifestLoadId = cargoManifestId
    AND cargoManifestContainerNumberId = containerId
    ORDER BY dateOfChange)

    LOOP
        SELECT operationName INTO opName
        FROM Operations
        WHERE id = getInformation.operationsId;

        out := out || 'Cargo Manifest Id - ' || getInformation.cargoManifestContainerCargoManifestLoadId || ' Container ID - ' || getInformation.cargoManifestContainerNumberId || ' User who made the modification - ' || getInformation.userUserName || ' Operation made - ' || opName || ' Date of the operation - ' || getInformation.dateOfChange || chr(10);

    END LOOP;

    return out;
END;



