package lapr.project.controller;

import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import lapr.project.model.Ship;

import java.util.ArrayList;
import java.util.List;

public class ListSomeShipDataController {

    private Company company;

    private Iterable<Ship> inOrder;

    private List<BriefSummary> briefSummaries;


    public ListSomeShipDataController(){

        company = App.getInstance().getCompany();
        inOrder = company.getBstShip().inOrder();
        briefSummaries = new ArrayList<>();
    }

    public List<BriefSummary> getShipList(){
        for (Ship s : inOrder){
            BriefSummary briefSummary = new BriefSummary(s.getMMSI(), s.getShipPosition().getTotalMovements(), s.getShipPosition().getDeltaDistance(), s.getShipPosition().getTravelledDistance());
            briefSummaries.add(briefSummary);
        }
        return briefSummaries;
    }

}
