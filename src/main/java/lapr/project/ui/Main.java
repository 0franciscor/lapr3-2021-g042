package lapr.project.ui;

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

<<<<<<< HEAD
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

=======
>>>>>>> 1703cd71642c66f498c33c9d67fa19cb43695a78
        do {

            System.out.println("Main Menu");
            System.out.println("0- Exit");
            option = Utils.readIntegerFromConsole("Type your option:");
            if (option == 0) System.exit(0);

        }while (option != 1);


    }
}

