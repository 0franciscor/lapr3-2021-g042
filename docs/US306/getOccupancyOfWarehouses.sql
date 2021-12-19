CREATE OR REPLACE FUNCTION getOccupancyOfWarehouse() RETURN VARCHAR2
IS
    outString VARCHAR2(2555);
    finalDate DATE;

    BEGIN

        finalDate:=sysdate+30;

        FOR loop
        IN (SELECT id, occupancy
        FROM Warehouse)

        LOOP
            outString := outString || 'Warehouse ID - ' || loop.id || ', Occupancy - ' || loop.occupancy || '% ' || chr(10)

        END LOOP;

        FOR LOOP2
        IN(SELECT cargoManifestLoadId, Id, expectedDepartureDate
        FROM Phases
        WHERE Phases.origin=storehouse
        AND Phases.expectedDepartureDate >= sysdate
        AND Phases.expectedDepartureDate <= finalDate)
        LOOP2

            FOR containers
            IN(SELECT ContainerNumberId
            FROM CargoManifestContainer
            WHERE CargoManifestLoadId=LOOP2.cargoManifestLoadId AND PhasesId=LOOP2.id)

            outString:=outString || 'Container - ' || containers.ContainerId || ', Expected Departure Date - ' || LOOP2.expectedDepartureDate || chr(10);

        END LOOP2;

        return outString;
    END;