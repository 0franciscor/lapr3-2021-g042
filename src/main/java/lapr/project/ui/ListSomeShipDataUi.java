package lapr.project.ui;

import lapr.project.controller.ListSomeShipDataController;
import lapr.project.model.BriefSummary;
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
     *
     */
    private List<BriefSummary> briefSummaries;

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

        System.out.println("Select how you want to sort the list of summaries");

        System.out.println("1 - Order by ascending order of travelled distance");
        System.out.println("2 - Order by descending order of total number of movements");
        System.out.printf("%nList of Summaries%n");

        int option = Utils.readIntegerFromConsole("Type your option: ");
        System.out.println(option);

       if (option == 1) {
            briefSummaries = listSomeShipDataController.OrganizeByAscendingOrder();
       }
        else {
            briefSummaries = listSomeShipDataController.OrganizeByDescendingOrder();
        }
        for (BriefSummary bs : briefSummaries){
            System.out.println(bs);
        }





    }
}
