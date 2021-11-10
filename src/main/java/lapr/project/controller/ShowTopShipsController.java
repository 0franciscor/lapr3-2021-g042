package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Summary;

import java.util.*;

/**
 * Class that allows the traffic manager to view the TOP-N Ships with most traveled distance.
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class ShowTopShipsController {

    /**
     * The controller's company
     */
    private Company company;

    /**
     * ShowTopShipsController Constructor
     */
    public ShowTopShipsController(){
        this.company = App.getInstance().getCompany();
    }

    /**
     * ShowTopShipsController Constructor
     */
    public ShowTopShipsController(Company company){
        this.company = company;
    }

    /**
     * Method that gets the top-N ships by distance.
     *
     * @param numberShips Number of top N ships
     * @param initialDate The initial Time, in order to define the time window
     * @param finalDate The final Time, in order to define the time window
     * @return a String with the organized info
     */
    public String getTopNShips(int numberShips, Date initialDate, Date finalDate){
        Map<Integer, List<Summary>> topShips = company.getBstShip().getTopNShips(numberShips, initialDate, finalDate);

        if(!topShips.isEmpty()) {
            StringBuilder shipString = new StringBuilder();
            for (Integer key : topShips.keySet()) {
                if(!topShips.get(key).isEmpty()) {
                    shipString.append("\n\nFor the Vessel Type: " + key + ", this is the data of the Ship:\n");
                    for (Summary summary : topShips.get(key))
                        shipString.append("\nThe ship with the " + summary.getMmsiCode() + " MMSI Code, traveled " + summary.getTravelledDistance() + " Kilometers at a Mean SOG of: " + summary.getMeanSog());
                }
            }

            shipString.append("\n\n");

            return String.valueOf(shipString);
        }
        return "There was no ship to demonstrate";
    }

    /**
     * @return the Controller's Company
     */
    public Company getCompany(){
        return this.company;
    }
}
