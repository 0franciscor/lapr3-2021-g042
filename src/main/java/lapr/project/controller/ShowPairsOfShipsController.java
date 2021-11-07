package lapr.project.controller;

import lapr.project.model.BstShip;
import lapr.project.model.Company;

import java.util.List;
import java.util.TreeMap;


/**
 * Class responsible for making the connection between the UI and the system when viewing a pairs of ships
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShowPairsOfShipsController {

    /**
     * Represents an instance of app.
     */
    private final App app;

    /**
     * Represents a instance of Company
     */
    private final Company company;

    /**
     * Represents a instance of BstShip
     */
    private final BstShip bstShip;

    /**
     * Initialize the controller
     */
    public ShowPairsOfShipsController() {
        this.app = App.getInstance();
        this.company = app.getCompany();
        this.bstShip=company.getBstShip();
    }

    /**
     * Initialize the controller receiving a company
     */
    public ShowPairsOfShipsController(Company company) {
        this.app = App.getInstance();
        this.company = company;
        this.bstShip=company.getBstShip();
    }

    public List<TreeMap<Double,String>> getPairsOfShip() {
        return bstShip.getIntendedPairsOfShips();
    }
}
