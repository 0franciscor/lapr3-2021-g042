package lapr.project.ui;

import lapr.project.controller.ListSomeShipDataController;
import lapr.project.mapper.dto.SummaryDto;
import lapr.project.model.BriefSummary;
import lapr.project.model.Ship;
import lapr.project.model.Summary;
import lapr.project.utils.Utils;

import java.util.List;

/**
 * Represents an interface with the Traffic Manager to view for all ships the MMSI, the total number of movements,
 * Travelled Distance and Delta Distance.
 *
 * @author Manuela Leite <1200720@isep.ipp.pt>
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ListSomeShipDataUi implements Runnable{

    /**
     * Represents an instance of List Some Ship Data Controller
     */
    private ListSomeShipDataController listSomeShipDataController;

    /**
     * Initializes the controller
     */
    public ListSomeShipDataUi(){
        listSomeShipDataController = new ListSomeShipDataController();
    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {
        System.out.printf("%nList of Summaries%n");

        List<BriefSummary> briefSummaries = listSomeShipDataController.getShipList();

        for (BriefSummary bs : briefSummaries){
            System.out.println(bs);
        }

    }
}
