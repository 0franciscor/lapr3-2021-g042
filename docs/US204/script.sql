insert into Container (NUMBERid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (987650321, 1569483, 'justo', 2.4, 1.5, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.9, 1.1, 181.7, 118.5);
insert into Container (NUMBERid, CHECKDIGIT, ISOCODE, MaxWeight, MAXVOLUMEPACKED, REPAIRRECOMMENDATION, CERTIFICATE, payload, tare, weight, maxweightpacked) values (695421863, 8150283, 'sagittis', 92.3, 179.3, '#REPAIRRECOMMENDATION', 'CERTIFICATE', 89.6, 20.7, 128.5, 72.1);

insert into Ship (mmsicode, imocode, NUMBERENERGYGENERATORS, generatoroutput, callsign, draft, shipname, vesseltypeid, shiplength, width, cargo) values ('529467097', 'IMO4419462', 82, 16.8, 'sit', 39.1, 'consequat', 100, 72.2, 61.5, 'in');
insert into Ship (mmsicode, imocode, NUMBERENERGYGENERATORS, generatoroutput, callsign, draft, shipname, vesseltypeid, shiplength, width, cargo) values ('696134988', 'IMO8583481', 57, 20.4, 'abc', 85.6, 'a', 17, 30.5, 16.9, 'magna');

insert into Country (countryname, continent) values ('Indonesia', 'Continent');
insert into Country (countryname, continent) values ('Libya', 'Continent');
insert into Country (countryname, continent) values ('China', 'Continent');
insert into Country (countryname, continent) values ('Montenegro', 'Continent');

insert into PlaceLocation (countryname, latitude, longitude) values ('Indonesia', '70', '-93');
insert into PlaceLocation (countryname, latitude, longitude) values ('Libya', '61', '41');
insert into PlaceLocation (countryname, latitude, longitude) values ('China', '62', '145');
insert into PlaceLocation (countryname, latitude, longitude) values ('Montenegro', '-16', '-99');

insert into PORTS (id, name, PLACELOCATIONLATITUDE, PLACELOCATIONlongitude) values (117638542, 'sapien', '70', '-93');
insert into PORTS (id, name, PLACELOCATIONLATITUDE, PLACELOCATIONlongitude) values (29536752, 'eget', '61', '41');
insert into PORTS (id, name, PLACELOCATIONLATITUDE, PLACELOCATIONlongitude) values (937194604, 'nec', '62', '145');

insert into CARGOMANIFESTLOAD(id,shipmmsicode,portid) values (10000,'529467097', 117638542);
insert into CARGOMANIFESTLOAD(id,shipmmsicode,portid) values (20000,'696134988', 29536752);

INSERT INTO PHASES(cargomanifestloadid,id,origin,destination,expecteddeparturedate,expectedarrivaldate,realdeparturedate,realarrivaldate)
VALUES (20000,1,'eget','nec','2021-11-04 18:44:33','2021-12-30 18:44:33','2021-11-04 18:44:33','2021-12-30 18:44:33');

INSERT INTO cargomanifestunload(id,phasescargomanifestloadid,phasesid,portid)
VALUES (951245368,20000,1,937194604);

INSERT INTO cargoManifestContainer(cargomanifestid,containernumberid,grosscontainer,xcontainer,ycontainer,zcontainer,PhasesId,PhasesCargoManifestLoadId )
VALUES (10000,987650321,12.6,1,1,1,1,10000);

INSERT INTO cargoManifestContainer(cargomanifestid,containernumberid,grosscontainer,xcontainer,ycontainer,zcontainer,PhasesId,PhasesCargoManifestLoadId,CargoManifestUnloadId)
VALUES (20000,695421863,12.6,1,3,1,1,20000,951245368);

CREATE OR REPLACE FUNCTION get_container_position (v_numberId int) return varchar

IS

    v_idCargoManifest int;
    v_CargoManifestUnloadId int;
    v_mmsi varchar(255);
    v_locationName varchar(255);
    v_locationNameAux varchar(255);
    v_arrivalDate timestamp;
    v_arrivalDate_aux timestamp;
    v_phases int;

    Cursor cargos IS
        Select CARGOMANIFESTID
        from CargoManifestContainer
        where CONTAINERNUMBERID=v_numberId;
        
begin 
   open cargos;
   LOOP 
   fetch cargos into v_idCargoManifest;
   exit when cargos%notfound;
   
   select CargoManifestUnloadId
   into v_CargoManifestUnloadId
   from CargoManifestContainer
   where PhasesCargoManifestLoadId=v_idCargoManifest; 
   
    if v_CargoManifestUnloadId IS NULL then
    
    Select SHIPMMSICODE into v_mmsi
    from CargoManifestLoad
    where ID = v_idCargoManifest;
    
    Select SHIPNAME into v_locationName
    from Ship
    where mmsiCode = v_mmsi;
    
    return ('SHIP, '|| (v_locationName)); 
    end if;
    
   END LOOP;
   close cargos;
   
   open cargos;
   LOOP 
   fetch cargos into v_idCargoManifest;
   exit when cargos%notfound;
   
   Select phasesId into v_phases
   from CargoManifestUnload
   where v_idCargoManifest=phasescargomanifestloadid; 
   
   Select realArrivalDate into v_arrivalDate_aux
   from phases
   where v_idCargoManifest=CargoManifestLoadId and id=v_phases; 
   
   Select destination into v_locationNameAux
   from phases
   where v_idCargoManifest=CargoManifestLoadId and id=v_phases; 
   
   if v_arrivalDate IS NULL then
   v_arrivalDate:=v_arrivalDate_aux;
   v_locationName:=v_locationNameAux;
   else if v_arrivalDate_aux>v_arrivalDate then
   v_arrivalDate:=v_arrivalDate_aux;
   v_locationName:=v_locationNameAux;
   end if;
   end if;
   
   
   END LOOP;
   return ('PORT, '|| (v_locationName)); 
   close cargos;
    
exception
    when no_data_found then
        return null;
end;