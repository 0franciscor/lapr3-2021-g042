package lapr.project.ui;

import lapr.project.controller.ShowPositionalMessagesController;
import lapr.project.utils.Utils;

import java.util.Date;
import java.util.List;

/**
 * Represents an interface with the Traffic Manager to view the positional messages temporarily organized and associated with each of the ships
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShowPositionalMessagesUI implements Runnable{

    /**
     * Represents an instance of Show Positional Messages Controller.
     */
    private final ShowPositionalMessagesController showPositionalMessagesCtrl;

    /**
     * Initializes the controller.
     */
    public ShowPositionalMessagesUI(){
        showPositionalMessagesCtrl = new ShowPositionalMessagesController();
    }

    /**
     * Invokes the necessary methods for the interface to function.
     */
    @Override
    public void run() {

        System.out.printf("%nViewing a Ship's Positional Messages in a given period%n");

        String mmsiCode = Utils.readLineFromConsole("Enter the MMSI code of the vessel you wish to obtain information from:");
        if( mmsiCode == null ||mmsiCode.length() != 9) {
            System.out.println("The ship MMSI code must be 9-digit long.");
        } else{
            if (showPositionalMessagesCtrl.shipExist(mmsiCode)){
                Date initialDate = Utils.readDateFromConsole("Enter the initial date of the information you want to obtain");
                Date finalDate = Utils.readDateFromConsole("Enter the final date of the information you want to obtain");
                if (finalDate != null && finalDate.before(initialDate)){
                    System.out.println("The end date must be later than the start date.");
                } else {
                    List<String> mesages = showPositionalMessagesCtrl.showPositionalMessages(initialDate,finalDate);
                    for (String message: mesages){
                        System.out.println(message);
                    }
                }
            } else {
                System.out.printf("%nThere is no ship in the system with this MMSI code%n");
            }
        }

    }



}
