package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class TrafficManagerUi implements Runnable{

    public TrafficManagerUi(){

    }

    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Import Ships from a text file", new ImportShipUI()));
        options.add(new MenuItem("Search ship's details", new SearchDetailsUI()));
        options.add(new MenuItem("See the positional messages", new ShowPositionalMessagesUI()));
        options.add(new MenuItem("Make a summary of a ship's movements", new MovementsSummaryUI()));
        options.add(new MenuItem("List all ships", new ListSomeShipDataUi()));
        options.add(new MenuItem("Pairs of Ships", new ShowPairsOfShipsUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nHuman Resources UI:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }

        } while (option != -1 );
    }
}
