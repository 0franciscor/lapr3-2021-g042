
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
        WHEN UPDATING THEN 2
        WHEN DELETING THEN 3
        WHEN INSERTING THEN 1
    END;

   SELECT COUNT(*) INTO counter FROM AuditTrails;
       counter := counter + 1;


    dbms_output.put_line('id: ' ||counter);
    dbms_output.put_line('id: ' || :NEW.userResponsibleForChanges);
    dbms_output.put_line('id: ' || transactionStatus);
    dbms_output.put_line('id: ' || :NEW.cargomanifestloadid);

    --dbms_output.put_line('id: ' ||:NEW.containerid);

    -- insert a row into the audit table

   INSERT INTO AuditTrails
   VALUES(:NEW.userResponsibleForChanges,transactionStatus,:NEW.containerNumberId,:NEW.cargoManifestLoadId,counter, sysdate);

END;




