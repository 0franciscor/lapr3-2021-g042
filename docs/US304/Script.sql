CREATE OR REPLACE PROCEDURE UpdateCargoManifestContainer(cargoId In Integer, containerId in Integer, tripId in Integer, x in Integer, y in Integer, z in Integer, gross in Float, portStaffName in Varchar)
IS

BEGIN

INSERT INTO CargoManifestContainer(containerNumberId, cargoManifestLoadId, completedPhase, xContainer, yContainer, zContainer, grossContainer, PhasesId, PhasesCargoManifestLoadId, CargoManifestUnloadId, userResponsibleForChanges);
VALUES(containerId, cargoId, tripId, x, y, z, gross, cargoId, )

END;


CREATE OR REPLACE TRIGGER AuditTrailsTrigger

    AFTER
    UPDATE OR DELETE OR INSERT
    ON CargoManifestContainer
    FOR EACH ROW

    DECLARE
        counter Integer;
        transactionStatus VARCHAR2(10);

    BEGIN
   -- determine the transaction type
        transactionStatus := CASE
        WHEN UPDATING THEN 1
        WHEN DELETING THEN 3
        WHEN INSERTING THEN 2
    END;

   SELECT COUNT(*) INTO counter FROM AuditTrails;
       counter := counter + 1;


    dbms_output.put_line('id: ' counter);
    dbms_output.put_line('id: ' :NEW.portstaff);
    dbms_output.put_line('id: ' transactionStatus);
    dbms_output.put_line('id: ' :NEW.cargomanifestloadid);

    --dbms_output.put_line('id: ' ||:NEW.containerid);

    -- insert a row into the audit table

   INSERT INTO AuditTrails
   VALUES(contador, :NEW.portstaff, transactionstatus, :NEW.cargomanifestloadid,:NEW.containerid);

END;




