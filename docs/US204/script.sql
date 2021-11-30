CREATE OR REPLACE FUNCTION get_container_position (numberId Container.numberId%TYPE) return INTEGER 

is
    containerNumberId Container.numberId%type;
    cargoscode CargoManifest_Container.containernumberId%type;

    Cursor cargos IS
        Select containernumberId
        from CargoManifest_Container
        where containerNumberId=numberId;
begin 
   open cargos;
    
exception
    when no_data_found then
        return null;
end;