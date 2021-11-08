package lapr.project.ui;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

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
            System.out.println("1- Do login");
            System.out.println("0- Exit");
            option = Utils.readIntegerFromConsole("Type your option:");
            if (option == 1)  new AuthUI().run();
            if (option == 0) System.exit(0);

        }while (option != 1 || option != 0);





        //ImportShip importShip = new ImportShip();
        //importShip.getFile("sships.csv");
        //System.out.println("Number of ships not imported: " + importShip.convertShips());

        //ShowPositionalMessagesUI ui = new ShowPositionalMessagesUI();
        //ui.run();

        //MovementsSummaryUI msUi = new MovementsSummaryUI();
        //msUi.run();

        //SearchDetailsUI sdu = new SearchDetailsUI();
        //sdu.run();

        //ListSomeShipDataUi listSomeShipDataUi = new ListSomeShipDataUi();
        //listSomeShipDataUi.run();

        //ShowPairsOfShipsUI ui = new ShowPairsOfShipsUI();
        //ui.run();

        //System.out.println(App.getInstance().getCompany().getBstShip().size());
        /*
        CalculatorExample calculatorExample = new CalculatorExample();
        int value = calculatorExample.sum(3, 5);

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, String.valueOf(value));
        }
        */

        //List<String> options = new ArrayList<>();



    }
}

