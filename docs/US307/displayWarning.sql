CREATE OR REPLACE FUNCTION(idWarehouse INTEGER) RETURN VARCHAR2
IS
    outString VARCHAR2(2555);
BEGIN
    outString := outString || 'The warehouse with ID ' || idWarehouse || ' it is full' || chr(10);
END;
