package lapr.project.ui;

import lapr.project.controller.ShowTopShipsController;
import lapr.project.utils.Utils;
import java.util.Date;

/**
 * Show Top N Ships UI
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class ShowTopNShipsUI implements Runnable{

    /**
     * The UI's Controller
     */
    private ShowTopShipsController showTopShipsController;

    /**
     * The UI's Constructor
     */
    public ShowTopNShipsUI(){
        showTopShipsController = new ShowTopShipsController();
    }

    /**
     * Interface method run.
     */
    public void run(){
        System.out.println("Please insert the Following Data:");

        int numShips;

        do{
            numShips = Utils.readIntegerFromConsole("\nPlease insert the number of Top N Ships: ");
        } while(numShips < 1);

        System.out.println("Importante note:\nDates should be inserted with the following format: dd-MM-yyyy HH:mm");

        Date initialDate;
        Date finalDate;

        do{
            initialDate = Utils.readDateFromConsole("\nPlease insert the initial date:\n");
            finalDate = Utils.readDateFromConsole("\nPlease insert the initial date:\n");
        } while(initialDate.after(finalDate));

        System.out.println(showTopShipsController.getTopNShips(numShips, initialDate, finalDate));

    }
}
