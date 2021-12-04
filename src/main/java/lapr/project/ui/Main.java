package lapr.project.ui;

import lapr.project.controller.App;
import lapr.project.controller.ImportPortController;
import lapr.project.controller.ImportShipController;
import lapr.project.data.SendToDatabase;
import lapr.project.model.ImportPort;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option;

        ImportShipController importShipController = new ImportShipController();

        importShipController.importFile("sships.csv");
        importShipController.importShips();



        ImportPortController importPortController = new ImportPortController();
        importPortController.importFile("sports.csv");
        importPortController.importPorts();

        System.out.println(App.getInstance().getCompany().getPortStr().getPortsLst());

        SendToDatabase sendToDatabase = new SendToDatabase();

        sendToDatabase.sendShipsAndLocationsToDatabase();
        sendToDatabase.sendPortsToDatabase();

        do {

            System.out.println("Main Menu");
            System.out.println("0- Exit");
            option = Utils.readIntegerFromConsole("Type your option:");
            if (option == 0) System.exit(0);

        }while (option != 1);


    }
}

