package lapr.project.controller;


import lapr.project.model.BstShip;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipLocationBST;

import java.util.Date;
import java.util.List;

/**
 * Class responsible for making the connection between the UI and the system when viewing a ship's positional messages
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShowPositionalMessagesController {

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
     * Represents a instance of ship
     */
    private Ship ship;

    /**
     * Initialize the controller
     */
    public ShowPositionalMessagesController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.bstShip=company.getBstShip();
    }

    /**
     * Initialize the controller receiving a company
     */
    public ShowPositionalMessagesController(Company company){
        this.app=App.getInstance();
        this.company=company;
        this.bstShip=company.getBstShip();
    }

    /**
     * Verification if a ship exists in the system through the MMSI code
     * @param mmsiCode Code of the ship that we want to know if it exists in the system
     * @return true if the ship exists, otherwise return false
     */
    public boolean shipExist(String mmsiCode){
        this.ship=bstShip.getShipByMmsiCode(mmsiCode);
        return ship != null;
    }

    /**
     * Obtain the positional messages of the intended ship within the indicated period of time
     * @param initialDate initial date of the intended period
     * @param finalDate final date of the intended period
     * @return List with requested positional messages
     */
    public List showPositionalMessages(Date initialDate, Date finalDate){
        ShipLocationBST shipLocationBst = ship.getShipPosition();
        return shipLocationBst.getPositionalMessages(initialDate,finalDate);
    }
}
