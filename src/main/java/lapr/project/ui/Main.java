package lapr.project.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

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
    public static void main(String[] args) throws IOException, SQLException {
        int option = 0;

        do {
            System.out.println("Main Menu");
            System.out.println("0- Exit");
            option = Utils.readIntegerFromConsole("Type your option:");
            if (option == 0) System.exit(0);

        }while (option != 1 || option != 0);


    }
}

