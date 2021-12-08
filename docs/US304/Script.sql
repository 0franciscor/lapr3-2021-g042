CREATE OR REPLACE FUNCTION US304(idCargoManifest INTEGER, idContainer INTEGER, idUser VARCHAR) return VARCHAR2 IS
    BEGIN
        SELECT * FROM AuditTrails
        WHERE cargoManifestContainerNumberId = idCargoManifest
        Order by id;
    END;
#trigger so insere em uma tabela o utilizador e depois vamos buscar nessa tabela o utilizador que alterou um dos determinados atributos de container ou cargoManifest
CREATE OR REPLACE TRIGGER audit_trail_trigger
    AFTER
    UPDATE OR DELETE OR INSERT
    ON cargoManifestContainer
    FOR EACH ROW
DECLARE
   transactionStatus VARCHAR2(10);
BEGIN
   -- determine the transaction type
        transactionStatus := CASE
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
         WHEN INSERTING THEN 'INSERT'
   END;

   -- insert a row into the audit table
   dbms_output.put_line('funcionou');
END;
/