package lapr.project.ui;

import lapr.project.controller.SearchDetailsController;
import java.util.Scanner;

/**
 * Represents an interface with the Traffic Manager to search the details of a ship using any of its codes: MMSI, IMO or Call Sign
 *
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class SearchDetailsUI implements Runnable {

    static Scanner sc = new Scanner(System.in);

    /**
     * Represents an instance of Search Details Controller
     */
    private SearchDetailsController searchDetailsController;

    /**
     * Initializes the controller.
     */
    public SearchDetailsUI(){
        searchDetailsController = new SearchDetailsController();
    }


    @Override
    public void run() {
        viewDetails();
    }

    public void viewDetails(){
        int option;
        try {
            System.out.println("Choose which code you want to perform the search with?");
            System.out.println("( 1 ) - MMSI");
            System.out.println("( 2 ) - IMO");
            System.out.println("( 3 ) - Call Sign");
            System.out.printf("Digite uma opcão: ");
            option = Integer.parseInt(sc.nextLine());
            System.out.println("Choosed option: "+ option);
            if(option == 1) {
                System.out.println("Insert the MMSI code: ");
                String mmsicode = sc.next();
                searchDetailsController.shipExistByMMSI(mmsicode);
                searchDetailsController.getShipDetails();
            } else if(option == 2) {
                /*System.out.println("Insert the IMO code: ");
                String imocode = sc.next();
                searchDetailsController.shipExistByIMO(imocode);
                searchDetailsController.getShipDetails();*/
            }
            else if(option == 3) {
                /*System.out.println("Insert the Call Sign:");
                String callsign = sc.next();
                searchDetailsController.shipExistByCallSign(callsign);
                searchDetailsController.getShipDetails();*/
            }

        }catch(IllegalArgumentException e){
            System.out.printf("%nMessage: %s%n", e.getMessage());
        }
    }

}
