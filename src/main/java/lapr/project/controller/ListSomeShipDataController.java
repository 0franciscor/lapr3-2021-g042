package lapr.project.controller;

import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for making the connection between the UI and the system when the user
 * wants to list for all ships the MMSI, the total number of movements, Travelled Distance and Delta Distance.
 *
 * @author Manuela Leite <1200720@isep.ipp.pt>
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ListSomeShipDataController {

    /**
     * Represents an instance of Company
     */
    private Company company;

    /**
     * Represents a list of the Ships
     */
    private Iterable<Ship> inOrder;

    /**
     * Represents a list of the Brief Summaries
     */
    private List<BriefSummary> briefSummaries;

    /**
     * Initialize the controller
     */
    public ListSomeShipDataController(){
        company = App.getInstance().getCompany();
        inOrder = company.getBstShip().inOrder();
        briefSummaries = new ArrayList<>();
    }

    /**This method allows the user to search a certain ship on the BST through its MMSI code (unique code).
     * @return The list with the brief details of the ships.
     * */
    public List<BriefSummary> getShipList(){
        for (Ship s : inOrder){
            BriefSummary briefSummary = new BriefSummary(s.getMMSI(), s.getShipPosition().getTotalMovements(), s.getShipPosition().getDeltaDistance(), s.getShipPosition().getTravelledDistance());
            briefSummaries.add(briefSummary);
        }
        return briefSummaries;
    }

}
