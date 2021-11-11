package lapr.project.controller;

import lapr.project.mapper.SummaryMapper;
import lapr.project.mapper.dto.SummaryDto;
import lapr.project.model.BstShip;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.Summary;

/**
 * The MovementsSummary Controller, the controller responsible for managing the Summary class, which allows the Traffic manager to create a summary of movements of a ship
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class MovementsSummaryController {

    /**
     * Represents an instance of BstShip
     */
    private final BstShip bstShip;

    /**
     * Represents the company
     */
    private final Company company;

    /**
     * Represents an instance of Summary Mapper Dto
     */
    private final SummaryMapper summaryMapper;

    /**
     * The class constructor
     */
    public MovementsSummaryController(){
        company = App.getInstance().getCompany();
        bstShip = company.getBstShip();
        summaryMapper = new SummaryMapper();
    }

    /**
     * Search a ship by his MMSI code
     * @param mmsiCode the MMSI code of a ship
     * @return the ship that matched the MMSI code
     */
    public Ship getShipByMmsiCode(String mmsiCode){
        return bstShip.getShipByMmsiCode(mmsiCode);
    }

    /**
     * Create a summary for a ship
     * @param ship the ship we want to create a summary
     * @return the summary
     */
    public Summary createSummaryForShip(Ship ship){
        return new lapr.project.model.Summary(ship);
    }

    /**
     * Create an object of type data transfer
     * @param summary the summary we intend to transform in a data transfer
     * @return the data transfer object
     */
    public SummaryDto createSummaryDto(lapr.project.model.Summary summary){
        return summaryMapper.toDto(summary);
    }

    /**
     * Verification if a ship exists in the system through the MMSI code
     * @param mmsiCode Code of the ship that we want to know if it exists in the system
     * @return true if the ship exists, otherwise return false
     */
    public boolean shipExist(String mmsiCode){
        if (mmsiCode == null) return false;
        Ship ship = bstShip.getShipByMmsiCode(mmsiCode);
        return ship != null;
    }



}
