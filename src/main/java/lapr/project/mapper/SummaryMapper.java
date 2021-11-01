package lapr.project.mapper;

import lapr.project.mapper.dto.SummaryDto;
import lapr.project.model.Summary;

/**
 * Transform objects of type Summary into objects of type SummaryDto
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class SummaryMapper {

    /**
     * Transforms an object of type Summary into an object of type SummaryDto
     * @param summary a summary
     * @return a summary dto
     */
    public SummaryDto toDto(Summary summary){

        return new SummaryDto(summary);
    }

}
