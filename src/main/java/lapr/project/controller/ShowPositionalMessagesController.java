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
     * Represents a instance of Company
     */
    private Company company;

    /**
     * Represents a instance of ShipLocationBST
     */
    private ShipLocationBST shipLocationBst;

    /**
     * Represents a instance of BstShip
     */
    private BstShip bstShip;

    /**
     * Represents a instance of ship
     */
    private Ship ship;

    /**
     * Initialize the controller
     */
    public ShowPositionalMessagesController(){
        this.company= new Company(); // Para alterar quando a App instanciar a company
        this.bstShip=company.getBstShip();
    }

    /**
     *
     * @param mmsiCode
     * @return
     */
    public boolean shipExist(String mmsiCode){
        return (this.ship = bstShip.getShipByMmsiCode(mmsiCode)) != null;
    }

    /**
     *
     * @param initialDate
     * @param finalDate
     * @return
     */
    public List<String> showPositionalMessages(Date initialDate, Date finalDate){
        this.shipLocationBst=ship.getShipPosition();
        return shipLocationBst.getPositionalMessages(initialDate,finalDate);
    }
}
