package lapr.project.mapper;
import lapr.project.mapper.dto.ShipDto;
import lapr.project.model.Ship;

/**
 * Transform objects of type Ship into objects of type ShipDto
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ShipMapper {

    /**
     * Transforms an object of type Ship into an object of type ShipDto
     * @param ship
     * @return a summary dto
     */
    public ShipDto toDto(Ship ship){
        return new ShipDto(ship);
    }
}
