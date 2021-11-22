package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.store.PortStore;

import java.util.Date;

/**
 * Class responsible for making the connection between the UI and the system when find the closest port
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class FindClosestPortController {

    /**
     * Represents an instance of app.
     */
    private final App app;

    /**
     * Represents an instance of Company
     */
    private final Company company;

    /**
     * Represents an instance of BstShip
     */
    private final BstShip bstShip;

    /**
     * Represents an instance of PortStore
     */
    private final PortStore portStore;

    /**
     * Represents an instance Ports2DTree
     */
    private final Ports2DTree ports2DTree;

    /**
     * Initialize the controller
     */
    public FindClosestPortController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.bstShip=company.getBstShip();
        this.portStore=company.getPortStr();
        this.ports2DTree= portStore.getPorts2DTree();
    }

    /**
     * Initialize the controller receiving a company
     */
    public FindClosestPortController(Company company){
        this.app=App.getInstance();
        this.company=company;
        this.bstShip=company.getBstShip();
        this.portStore=company.getPortStr();
        this.ports2DTree= portStore.getPorts2DTree();
    }

    /**
     * Get the closest port of a particular ship on a certain date
     * @param callSign The ship's Call sign
     * @param date the date for search
     */
    public Ports findClosestPort(String callSign, Date date){
        Ship ship= bstShip.getShipByCallSign(callSign);
        if(ship!=null){
            ShipLocationBST shipLocationBST=ship.getShipPosition();
            ShipLocation shipLocation=shipLocationBST.getShipLocationByDate(date);
            return (Ports) ports2DTree.findNearestNeighbour(Double.parseDouble(shipLocation.getLatitude()),Double.parseDouble(shipLocation.getLongitude()));
        }
        return null;
    }


}
