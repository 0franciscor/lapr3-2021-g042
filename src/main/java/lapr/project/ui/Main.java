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

        do {
            System.out.println("Main Menu");
            System.out.println("0- Exit");
            option = Utils.readIntegerFromConsole("Type your option:");
            if (option == 0) System.exit(0);

        }while (option != 1);


    }
}

