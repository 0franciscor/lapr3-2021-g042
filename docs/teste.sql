CREATE OR REPLACE FUNCTION US204 (containerNumberid INT) RETURN VARCHAR
IS
    cargoscode INT;
    cmucmu INT;
    v_shipmmsi INT;
    v_shipname VARCHAR(255);
    v_trip INT;
    v_datareal TIMESTAMP;
    v_portid INT;
    v_portname VARCHAR(255);
    v_datarealatual TIMESTAMP;
    v_cargoFinal integer;
    v_destination Varchar(255);
    counter Integer:=0;

    Cursor cargos IS
        Select cargoManifestLoadid
        from CargoManifest_Container
        where containerid=containerNumberid
        AND containerid=containerNumberid;
BEGIN


   open cargos;
    LOOP
        fetch cargos INTO cargoscode;
        Exit When cargos%notfound;
        SELECT CargoManifestUnloadid INTO cmucmu
        FROM CargoManifest_Container
        WHERE cargoManifestLoadid=cargoscode
        AND containerId=containerNumberId;



            IF cmucmu is NULL THEN

            SELECT shipmmsi INTO v_shipmmsi
            FROM CargoManifestLoad
            WHERE id=cargoscode;

            SELECT name INTO v_shipname
            FROM Ship
            WHERE mmsi=v_shipmmsi;

            return ('SHIP: ' || v_shipname);
            END IF;

        END LOOP;
        CLOSE cargos;

    open cargos;
    LOOP
        fetch cargos INTO cargoscode;
        Exit When cargos%notfound;

        SELECT tripid INTO v_trip
        FROM CargoManifest_Container
        WHERE cargomanifestloadid=cargoscode
        AND containerid=containerNumberid;

        SELECT realArrivalDate INTO v_datareal
        FROM Trip
        WHERE cargoManifestLoadid=cargoscode
        AND id= v_trip;

        counter := counter +1;

        IF counter = 1  then
            v_datarealatual:= v_datareal;
            v_cargoFinal:= cargoscode;
        ELSE IF counter > 1 AND v_datareal > v_datarealatual THEN
            v_datarealatual := v_datareal;
            v_cargoFinal:= cargoscode;
            END IF;
        END IF;

        END LOOP;
        CLOSE cargos;

        select destination INTO v_destination
        From Trip
        Where realArrivalDate = v_datarealatual
        AND cargomanifestloadId= v_cargoFinal;

        return ('Port: ' || v_destination);
END;

Declare
 containerNumberid Varchar(255);

Begin
    containerNumberid := US204(748163149);
    dbms_output.put_line(containerNumberid);

End;


CREATE OR REPLACE PROCEDURE US205 (mmsiCode in Varchar, output out Varchar)
IS
    cmunloadNumber Integer;
    tripNumber Integer;
    cargoscode Cargomanifestload.id%type;
    proxLoc Trip.origin%type;
    nextPort Trip.origin%type;
    contador Integer :=0;
    typeIsoCode container.isoCode%type;
    loadWeight container.weight%type;
    Cursor cargos IS
        Select id
        from cargomanifestload
        where shipmmsi=mmsiCode
        Order by id;

Begin
open cargos;
    LOOP
        fetch cargos INTO cargoscode;
        Exit When cargos%notfound;
        dbms_output.put_line('cargo id: ' ||cargoscode);
        SELECT Count(*) INTO cmunloadNumber
                FROM cargomanifestunload
                Where cargomanifestunload.cargomanifestloadid = cargoscode;

                dbms_output.put_line(cmunloadNumber);

                SELECT COUNT(*) INTO tripNumber
                FROM Trip
                Where Trip.cargomanifestloadid = cargoscode;

                dbms_output.put_line(tripNumber);

                IF tripNumber = cmunloadNumber THEN
                        dbms_output.put_line('cargo finalizado id: ' ||cargoscode);

                ELSE
                    select destination INTO proxLoc
                    from Trip
                    where id=cmunloadNumber+1
                    AND cargomanifestloadid= cargoscode;
                    dbms_output.put_line('proximo porto: ' ||proxLoc);

                    contador:= contador + 1;

                    IF contador=1 THEN
                        nextPort:= proxLoc;
                        output:=output||'Next Port: '|| nextPort || chr(10);
                    End IF;

                    IF proxLoc=nextPort THEN

                        FOR loop
                        IN(Select cargomanifest_container.containerid,cargomanifest_container.xContainer,cargomanifest_container.yContainer,cargomanifest_container.zContainer
                            from cargomanifest_container
                            inner join Trip
                            on(cargomanifest_container.cargomanifestloadid = Trip.cargomanifestloadid)
                            where cargomanifest_container.cargomanifestloadid=cargoscode
                            AND cargomanifest_container.Tripid= cmunloadNumber+1
                            AND Trip.destination= proxLoc)
                        LOOP
                            dbms_output.put_line('asdasd: ' ||loop.containerid);
                            output:=output||'Container number: '|| loop.containerid|| ' With position-> x:'|| loop.xContainer|| ' y:' || loop.yContainer || ' z:'||loop.zContainer || chr(10);

                            select isoCode, weight into typeIsoCode, loadWeight
                            from container
                            where id= loop.containerid;

                            output:=output || 'Type(In iso Code): ' || typeIsoCode || ' Load: ' || loadWeight || chr(10);

                        END LOOP;

                    END IF;

                END IF;

            END LOOP;
        Close cargos;
END;


Declare
output Varchar2(2555);
Begin
    US205('210950000',output);
    dbms_output.put_line(output);

End;


-- US 206 --

CREATE OR REPLACE PROCEDURE US206 (mmsiCode in Varchar, output out Varchar)
IS
    cmunloadNumber Integer;
    bool Boolean;
    tripNumber Integer;
    cargoscode Cargomanifestload.id%type;
    proxLoc trip.origin%type;
    contador Integer :=0;
    nextPort trip.origin%type;
    typeIsoCode container.isoCode%type;
    loadWeight container.weight%type;

    localToCompare Varchar(255);


Cursor cargos IS
        Select id
        from cargomanifestload
        where shipmmsi=mmsiCode
        Order by id;

Begin
open cargos;
    LOOP
        fetch cargos INTO cargoscode;
        Exit When cargos%notfound;
        dbms_output.put_line('cargo id: ' ||cargoscode);
        SELECT Count(cargomanifestunload.cargomanifestloadid) INTO cmunloadNumber
                FROM cargomanifestunload
                Where cargomanifestunload.cargomanifestloadid = cargoscode;

                dbms_output.put_line(cmunloadNumber);

                SELECT COUNT(Trip.cargomanifestloadid) INTO tripNumber
                FROM Trip
                Where Trip.cargomanifestloadid = cargoscode;

                dbms_output.put_line(tripNumber);

                IF tripNumber = cmunloadNumber THEN
                        dbms_output.put_line('cargo finalizado id: ' ||cargoscode);

                ELSE
                    select destination INTO proxLoc
                    from Trip
                    where id=cmunloadNumber+1
                    AND cargomanifestloadid= cargoscode;
                    dbms_output.put_line('proximo porto: ' ||proxLoc);

                    contador:= contador + 1;

                    IF contador=1 THEN
                        nextPort:= proxLoc;
                        output:=output||'Next Port: '|| nextPort || chr(10);
                    End IF;

                    select origin into localToCompare
                    from trip
                    where id=1
                    AND cargomanifestloadid=cargoscode;

                    IF localToCompare = nextPort THEN

                        dbms_output.put_line('ID do cargo com os container a encher: ' ||cargoscode);
                        For loop
                        IN(select containerid
                        from cargomanifest_container
                        where cargomanifestloadid= cargoscode)
                        LOOP
                            dbms_output.put_line('containers: ' ||loop.containerid);
                            output:=output ||'Container number: '|| loop.containerid || chr(10);

                            select isoCode, weight into typeIsoCode, loadWeight
                            from container
                            where id= loop.containerid;

                            output:=output || 'Type(In iso Code): ' || typeIsoCode || ' Load: ' || loadWeight || chr(10);



                        END LOOP;

                        Exit;
                    END IF;
                END IF;

            END LOOP;

            Close cargos;


END;

Declare
output Varchar2(2555);
Begin
    US206('636092932',output);
    dbms_output.put_line(output);

End;

CREATE OR REPLACE PROCEDURE US207 (givenYear in INTEGER, mmsiCode in VARCHAR, totalCargoManifest out INTEGER, media out FLOAT)
IS
    CURSOR cargoManifestsLoaded IS
    SELECT id
    FROM cargoManifestLoad
    WHERE shipMmsi = mmsiCode
    AND isConcluded = 1;
    lattestTrip INTEGER;
    yearOfCargo INTEGER;
    containerCargo INTEGER := 0;
    totalContainers INTEGER := 0;
    arrivalDate date;
    CargoManifestloadedid integer;


BEGIN
    totalCargoManifest := 0;
    OPEN cargoManifestsLoaded;
    LOOP
        FETCH cargoManifestsLoaded INTO CargoManifestloadedid;
        EXIT WHEN cargoManifestsLoaded%NOTFOUND;

        SELECT realArrivalDate into arrivalDate
        FROM Trip
        WHERE cargoManifestLoadId = CargoManifestloadedid
        AND id = (select MAX(id) from trip where cargoManifestLoadId = CargoManifestloadedid);

        SELECT EXTRACT(YEAR FROM TO_DATE(arrivalDate,  'YY.MM.DD HH24:MI:SS')) INTO yearOfCargo
        FROM DUAL;

        IF yearOfCargo = givenYear THEN
            SELECT COUNT (*) INTO containerCargo
            FROM cargoManifest_Container
            WHERE cargoManifestLoadId = CargoManifestloadedid;
            totalContainers := totalContainers + containerCargo;

            totalCargoManifest := totalCargoManifest + 1;

        END IF;

    END LOOP;
    Close cargoManifestsLoaded;

    IF totalContainers = 0 OR totalCargoManifest = 0 THEN
        media := 0;
    ELSE
        media := totalContainers/totalCargoManifest;
    END IF;

END;

Declare
contadorReal Integer;
somaTotalContainer Integer;
Begin
    US207(2004,'212180000', contadorReal, somaTotalContainer);
    dbms_output.put_line('containers: ' ||somaTotalContainer);
    dbms_output.put_line('cargos: ' ||contadorReal);

End;

 -- US208 --
CREATE OR REPLACE PROCEDURE US208 (CargoManifestloadedId in INTEGER, shipmmsi in Varchar, ratio out FLOAT) IS

    totalContainers INTEGER;
    shipCapacity FLOAT;

    BEGIN

    SELECT COUNT (*) INTO totalContainers
    FROM CargoManifest_Container
    WHERE cargoManifestLoadId = CargoManifestloadedId;

    SELECT capacity INTO shipCapacity
    FROM Ship
    WHERE mmsi = shipmmsi;

    ratio:= (totalContainers/shipCapacity)*100;

END;

Declare
ratio Float;
Begin
    US208(3,'258692000',ratio);
    dbms_output.put_line(ratio);

End;


set serveroutput on;




CREATE OR REPLACE PROCEDURE US209 (mmsiCode in VARCHAR, givenDate in timestamp, occupancyRate out FLOAT)
IS

    CURSOR cargoManifestsloaded IS
    SELECT id
    FROM CargoManifestLoad
    WHERE shipMmsi = mmsiCode;

    totalContainers INTEGER;
    capacityShip FLOAT;
    cargoManifestsloadedId CargoManifestLoad.Id%type;
    date1 timestamp;
    date2 timestamp;
    numberOfTrip Integer;
    finalContainer Integer:=0;
    cont INTEGER;



BEGIN

    OPEN cargoManifestsloaded;

    LOOP
        FETCH cargoManifestsloaded INTO cargoManifestsloadedId;
        EXIT WHEN cargoManifestsloaded%NOTFOUND;

        FOR trips IN
        (SELECT Trip.id
        FROM Trip
        WHERE Trip.cargoManifestLoadId = cargoManifestsloadedId)
        LOOP
            SELECT realDepartureDate, realArrivalDate, id INTO date1, date2, numberOfTrip
            FROM Trip
            WHERE id = trips.id
            AND cargoManifestLoadId = cargoManifestsloadedId;
                dbms_output.put_line(date1);
                dbms_output.put_line(date2);
                dbms_output.put_line('given date:'|| givenDate);

            IF (date1 <= givenDate AND date2 >= givenDate) THEN
                SELECT COUNT (*) INTO totalContainers
                FROM CargoManifest_Container
                WHERE tripId >= numberOfTrip
                AND cargoManifestLoadId = cargoManifestsloadedId;
                dbms_output.put_line(totalContainers);
                finalContainer:= finalContainer + totalContainers;
            END IF;
        END LOOP;


    END LOOP;

    Close cargoManifestsloaded;

    SELECT capacity INTO capacityShip
    FROM Ship
    WHERE mmsi = mmsiCode;

    occupancyRate:= (finalContainer/capacityShip)*100;

END;

Declare
datemig date;
ratio float;
Begin
    datemig := TO_TIMESTAMP('14.10.21 18:44:33', 'dd/mm/yy hh24:mi:ss');

    US209('210950000',datemig,ratio);
    dbms_output.put_line(ratio);

End;


CREATE OR REPLACE PROCEDURE US210 (output out VARCHAR2) IS

    ships VARCHAR(255);
    nextMonday DATE;
    cont INTEGER;
    arrivalDestination VARCHAR(255);
    nTrips INTEGER;
    arrivalDate DATE;
    lattestDate DATE;
    slatitude VARCHAR(255);
    slongitude VARCHAR(255);
    cargoManifestLoadedID INTEGER;
    totalCargoManifests INTEGER;
    counter INTEGER;
    finalDestination VARCHAR(255);
    flag BOOLEAN;

    CURSOR allShips IS
    SELECT mmsi FROM Ship;

    CURSOR cargoManifestsLoaded IS
    SELECT id FROM CargoManifestLoad
    WHERE shipMmsi = ships;


BEGIN

    SELECT NEXT_DAY(sysdate,'SEGUNDA') INTO nextMonday FROM dual;

    output := output || 'Ships ready in next Monday (' || nextMonday || ')' || chr(10);

    OPEN allShips;

    LOOP
        FETCH allShips INTO ships;
        EXIT WHEN allShips%NOTFOUND;

        flag := false;
        nTrips := 0;
        cont := 0;

        OPEN cargoManifestsLoaded;

        LOOP
            FETCH cargoManifestsLoaded into cargoManifestLoadedID;
            EXIT WHEN cargoManifestsLoaded%NOTFOUND;

            flag := true;


            SELECT COUNT (*) INTO nTrips
            FROM Trip
            WHERE cargoManifestLoadId = cargoManifestLoadedID;

            SELECT expectedArrivalDate INTO arrivalDate
            FROM Trip
            WHERE id = nTrips
            AND cargoManifestLoadId = cargoManifestLoadedID;

            IF (arrivalDate < nextMonday) THEN
                cont := cont + 1;
            END IF;
        END LOOP;
        --Verificar se cont (conta todos os cm que acabam antes da proxima segunda) = total cargos--
        CLOSE cargoManifestsLoaded;
        IF flag=true Then
            SELECT COUNT (*) INTO totalCargoManifests
            FROM CargoManifestLoad
            WHERE shipMmsi = ships;

            IF cont = totalCargoManifests THEN
                counter := 0;
                OPEN cargoManifestsLoaded;
                LOOP

                    FETCH cargoManifestsLoaded into cargoManifestLoadedID;
                    EXIT WHEN cargoManifestsLoaded%NOTFOUND;

                    SELECT COUNT (*) INTO nTrips
                    FROM Trip
                    WHERE cargoManifestLoadId = cargoManifestLoadedID;


                    SELECT expectedArrivalDate, destination INTO arrivalDate, arrivalDestination
                    FROM Trip
                    WHERE id = nTrips
                    AND cargoManifestLoadId = cargoManifestLoadedID;

                    counter := counter + 1;

                    --Definir na primeira vez os valores para a comparaçao--
                    IF counter = 1 THEN
                        finalDestination := arrivalDestination;
                        lattestDate := arrivalDate;
                    END IF;
                    IF counter > 1 AND arrivalDate > lattestDate THEN
                        finalDestination := arrivalDestination;
                        lattestDate := arrivalDate;
                    END IF;
                END LOOP;

                CLOSE cargoManifestsLoaded;

                 output:= output || 'MMSI: '|| ships || ' Located at --> ' ||finalDestination|| chr(10);

            END IF;
        END IF;


        IF flag = false THEN

            SELECT latitude, longitude INTO slatitude, slongitude
            FROM ShipPosition
            WHERE shipMmsi = ships
            AND dateaismessage= (Select MAX(dateaismessage) from ShipPosition Where shipMmsi = ships);

            output := output || 'MMSI: '|| ships || ' Located at --> Latitude: ' || slatitude || ' Longitude: ' || slongitude || chr(10);
        END IF;
    END LOOP;
    CLOSE allShips;
END;


Declare
contadorReal Varchar2(2500);

Begin
    US210(contadorReal);
    dbms_output.put_line('cargos: ' ||contadorReal);

End;
