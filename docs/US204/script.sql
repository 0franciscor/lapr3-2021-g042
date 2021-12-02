CREATE OR REPLACE FUNCTION get_container_position (v_numberId int) return varchar

IS
    
    v_idCargoManifest int;
    v_cargoManifestUnloadPhasesCargoManifestLoadiId int;
    v_mmsi varchar(255);
    v_locationName varchar(255);
    v_locationNameAux varchar(255);
    v_arrivalDate timestamp;
    v_arrivalDate_aux timestamp;
    v_phases int;

    Cursor cargos IS
        Select cargoManifesLoadtid
        from CargoManifest_Container
        where containernumberId=v_numberId;
        
begin 
   open cargos;
   LOOP 
   fetch cargos into v_idCargoManifest;
   exit when cargos%notfound;
   
   select cargoManifestUnloadPhasesCargoManifestLoadiId
   into v_cargoManifestUnloadPhasesCargoManifestLoadiId
   from CargoManifest_Container
   where cargoManifesLoadtid=v_idCargoManifest; 
   
    if v_cargoManifestUnloadPhasesCargoManifestLoadiId IS NULL then
    
    Select ShipmmsiCode into v_mmsi
    from CargoManifestLoad
    where id = v_idCargoManifest;
    
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
   
   Select Phasesid into v_phases
   from CargoManifestLoad
   where v_idCargoManifest=CargoManifestLoadiId ; 
   
   Select realArrivalDate into v_arrivalDate_aux
   from phases
   where v_idCargoManifest=CargoManifestLoadiId and id=v_phases; 
   
   Select destination into v_locationNameAux
   from phases
   where v_idCargoManifest=CargoManifestLoadiId and id=v_phases; 
   
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