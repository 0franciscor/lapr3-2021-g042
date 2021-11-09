package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class HumanResourcesUi implements Runnable{

    public HumanResourcesUi() {
    }

    @Override
    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        //options.add(new MenuItem("Register a Employee", new RegisterEmployeeUI()));

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
