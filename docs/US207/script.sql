CREATE OR REPLACE PROCEDURE US207 (anoVer in Varchar, mmsiCode in Varchar, contadorReal out Integer, somaTotalContainer out Float)
IS
    shipscode Ship.mmsicode%type;
    cargoscode Cargomanifestload.id%type;
    cmunload Integer;
    bool Boolean;
    cmload Integer;
    realDate date;
    summ Integer;
    maximo Integer;
    ano Integer;
    contadorContainer Integer;


    Cursor cargos IS
        Select id
        from cargomanifestload
        where shipmmsicode=mmsiCode;
BEGIN
    contadorReal :=0;
    somaTotalContainer:=0;

   open cargos;
    LOOP
        fetch cargos INTO cargoscode;
        Exit When cargos%notfound;
        dbms_output.put_line('cargo id: ' ||cargoscode);
        SELECT Count(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID) INTO cmunload
                FROM CARGOMANIFESTUNLOAD
                inner join CARGOMANIFESTLOAD
                on(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID= CARGOMANIFESTLOAD.id)
                Where CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID = cargoscode;

                dbms_output.put_line(cmunload);

                SELECT COUNT(Phases.cargomanifestloadid) INTO cmload
                FROM Phases
                inner join CARGOMANIFESTLOAD
                on(CARGOMANIFESTLOAD.ID=Phases.cargomanifestloadid)
                Where Phases.cargomanifestloadid = cargoscode;

                dbms_output.put_line(cmload);

                IF cmload= cmunload THEN
                    dbms_output.put_line('Cargo manifest terminado');
                    Select MAX(phases.id) INTO maximo
                    from phases
                    where phases.cargomanifestloadid= cargoscode;

                    dbms_output.put_line(maximo);

                    select realarrivaldate into realDate
                    from phases
                    where id = maximo
                    AND cargomanifestloadid= cargoscode;

                    SELECT EXTRACT( YEAR FROM TO_DATE( realDate,  'YY.MM.DD HH24:MI:SS' ) )into ano
                    FROM DUAL;

                    select COunt(*) into summ
                    from phases
                    where id= maximo
                    AND cargomanifestloadid=cargoscode
                    AND ano = anoVer;

                    contadorReal := contadorReal + summ;
                    IF summ >0 THEN
                        select COUNT(*) INTO contadorContainer
                        From cargomanifest_container
                        where cargomanifestid= cargoscode;


                        somaTotalContainer := somaTotalContainer + contadorContainer;
                    END IF;

                ELSE
                    dbms_output.put_line('Cargo manifest nao terminado');

                END IF;
    END LOOP;
        dbms_output.put_line('Cargo terminados: ' || contadorReal);
        dbms_output.put_line('Total contentores: ' || somaTotalContainer);
END;