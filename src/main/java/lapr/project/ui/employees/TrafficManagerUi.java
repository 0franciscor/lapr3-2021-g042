package lapr.project.ui.employees;

import lapr.project.ui.MenuItem;
import lapr.project.ui.funcionalities.ImportShipsUi;
import lapr.project.ui.funcionalities.SearchDetailsUi;
import lapr.project.ui.funcionalities.ShowPositionalMessagesUi;
import lapr.project.ui.Utils;

import java.util.ArrayList;
import java.util.List;

public class TrafficManagerUi implements Runnable{
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Import ships from a text file into a BST", new ImportShipsUi()));
        options.add(new MenuItem("Search the details of a ship using any of its codes: \n" +
                "MMSI, IMO or Call Sign", new SearchDetailsUi()));
        options.add(new MenuItem("Have the positional messages temporally \n" +
                "organized and associated with each of the ships", new ShowPositionalMessagesUi()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nShip Captain Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }

        } while (option != -1 );
    }
}
