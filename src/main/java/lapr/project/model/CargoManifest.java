package lapr.project.model;

import java.util.Date;

/**
 * Represents a Cargo Manifest
 */
public class CargoManifest {

    /**
     * The date of the cargo manifest
     */
    private Date date;

    /**
     * The total number of containers that will be loaded or offloaded
     */
    private int totalNumberOfContainers;

    /**
     * Enum type that represents the destination of the cargo manifest
     */
    public enum Destination{
        SHIP, PORT
    }

    /**
     * MMSI code of the ship associated with a cargo manifest
     */
    private String mmsiCodeShip;

    /**
     * The destination of the cargo manifest
     */
    private Destination destination;

    /**
     * Construct an instance of Cargo Manifest
     * @param date
     * @param totalNumberOfContainers
     * @param mmsiCodeShip
     * @param destination
     */
    public CargoManifest(Date date, int totalNumberOfContainers, String mmsiCodeShip, Destination destination) {
        this.date = date;
        this.totalNumberOfContainers = totalNumberOfContainers;
        this.mmsiCodeShip = mmsiCodeShip;
        this.destination = destination;
    }

    /**
     * get the date of the cargo manifest
     * @return the date of creation of the cargo manifest
     */
    public Date getDate() {
        return date;
    }

    /**
     * get the total number of container
     * @return the total number of container
     */
    public int getTotalNumberOfContainers() {
        return totalNumberOfContainers;
    }

    /**
     * get the mmsi code of the ship associated with the cargo manifest
     * @return the mmsi code
     */
    public String getMmsiCodeShip() {
        return mmsiCodeShip;
    }

    /**
     * get the destination of the cargo manifest
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }
}
