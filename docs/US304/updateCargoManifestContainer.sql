    CREATE OR REPLACE PROCEDURE UpdateCargoManifestContainer(cnId in INTEGER, gross in FLOAT, userResp in VARCHAR)
    IS

    BEGIN

            UPDATE CargoManifestContainer
            SET grossContainer = gross,
            userResponsibleForChanges = userResp
            WHERE containerNumberId = cnId;

    END;


insert into USERSYSTEM (username, password, roleid)
values('manuela_1200720', '123456', 7);

    BEGIN
        updateCargoManifestContainer(456789423,'16,7', 'manuela_1200720');
    END;


