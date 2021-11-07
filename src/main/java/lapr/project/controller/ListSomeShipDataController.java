package lapr.project.controller;

import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import lapr.project.model.Ship;

import java.util.*;

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
    private final Company company;

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
        for (Ship s : inOrder){
            BriefSummary briefSummary = new BriefSummary(s.getMMSI(), s.getShipPosition().getTotalMovements(), s.getShipPosition().getDeltaDistance(), s.getShipPosition().getTravelledDistance());
            briefSummaries.add(briefSummary);
        }
    }

    /**
     * Initialize the controller
     */
    public ListSomeShipDataController(Company company){
        this.company = company;
        inOrder = company.getBstShip().inOrder();
        briefSummaries = new ArrayList<>();
        for (Ship s : inOrder){
            BriefSummary briefSummary = new BriefSummary(s.getMMSI(), s.getShipPosition().getTotalMovements(), s.getShipPosition().getDeltaDistance(), s.getShipPosition().getTravelledDistance());
            briefSummaries.add(briefSummary);
        }
    }

    /**
     * Organize the list of brief summaries by ascending order of travelled distance
     * @return the ordered list
     */
    public List<BriefSummary> OrganizeByDescendingOrder(){
        Collections.sort(briefSummaries, new Comparator<BriefSummary>() {
            @Override
            public int compare(BriefSummary o1, BriefSummary o2) {
                if (o1.getTravelledDistance() < o2.getTravelledDistance()) return 1;
                if (o1.getTravelledDistance() > o2.getTravelledDistance()) return -1;
                else  return 0;
            }
        });
        return briefSummaries;
    }

    /**
     * Organize the list of brief summaries by descending order of number of movements
     * @return the ordered list
     */
    public List<BriefSummary> OrganizeByAscendingOrder(){
        Collections.sort(briefSummaries, new Comparator<BriefSummary>() {
            @Override
            public int compare(BriefSummary o1, BriefSummary o2) {
                if (o1.getTotalNumberOfMovements() > o2.getTotalNumberOfMovements()) return 1;
                if (o1.getTotalNumberOfMovements() < o2.getTotalNumberOfMovements()) return -1;
                else  return 0;
            }
        });
        return briefSummaries;
    }

    public List<BriefSummary> getBriefSummary() { return briefSummaries;}


}
