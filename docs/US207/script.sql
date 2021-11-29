Create or Replace procedure us207CargoManifest(ano in Integer, mmsiCode in Varchar, totalCargoManifest out Integer, medContainer out Integer) as
Begin
Declare
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
    somaTotalContainer Integer :=0;
    contadorReal Integer :=0;


    Cursor cargos IS
        Select id
        from cargomanifestload
        Right outer join Ship
        on(cargomanifestload.shipmmsicode= Ship.mmsicode)
        where shipmmsicode=mmsicode;

    open cargos;
    LOOP
        fetch cargos INTO cargoscode;
        Exit When cargos%notfound;

        SELECT Count(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID) INTO cmunload
                FROM CARGOMANIFESTUNLOAD
                inner join CARGOMANIFESTLOAD
                on(CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID= CARGOMANIFESTLOAD.id)
                Where CARGOMANIFESTUNLOAD.PHASESCARGOMANIFESTLOADID = cargoscode;

                dbms_output.put_line(cmunload);

                SELECT COUNT(Etapa.cargomanifestloadid) INTO cmload
                FROM Etapa
                inner join CARGOMANIFESTLOAD
                on(CARGOMANIFESTLOAD.ID=Etapa.cargomanifestloadid)
                Where Etapa.cargomanifestloadid = cargoscode;

                dbms_output.put_line(cmload);

                IF cmload= cmunload THEN
                    dbms_output.put_line('Cargo manifest terminado');
                    Select MAX(etapa.id) INTO maximo
                    from etapa
                    where etapa.cargomanifestloadid= cargoscode;

                    dbms_output.put_line(maximo);

                    select realarrivaldate into realDate
                    from etapa
                    where id = maximo
                    AND cargomanifestloadid= cargoscode;

                    SELECT EXTRACT( YEAR FROM TO_DATE( realDate,  'YY.MM.DD HH24:MI:SS' ) )into ano
                    FROM DUAL;

                    select COunt(*) into summ
                    from etapa
                    where id= maximo
                    AND cargomanifestloadid=cargoscode
                    AND ano = ano;

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
        dbms_output.put_line('Media: '|| somaTotalContainer/contadorReal);


End;