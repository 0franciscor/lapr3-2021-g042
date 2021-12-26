CREATE OR REPLACE TRIGGER warning
BEFORE INSERT OR UPDATE
ON Phases
FOR EACH ROW

DECLARE
    destinationAux VARCHAR(255);
    flag INTEGER;
    ocp FLOAT;
    idWarehouse INTEGER;

    SELECT destination INTO destinationAux
    FROM Phases
    WHERE id = NEW.PhasesId;

    SELECT COUNT(*) INTO flag
    FROM Warehouse
    WHERE name = destinationAux;

    IF flag != 0 THEN

        SELECT occupancy INTO ocp
        FROM Warehouse
        WHERE name = destinationAux;

        SELECT id INTO idWarehouse
        FROM Warehouse
        WHERE name = destinationAux;

        IF ocp >= 100 THEN
            raise_application_error(-20000, 'The warehouse with ID ' || idWarehouse ||'it is fully occupy' );
        END IF;
    END IF;

END;


