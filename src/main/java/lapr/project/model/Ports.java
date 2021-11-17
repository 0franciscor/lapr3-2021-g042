package lapr.project.model;

/**
 * Represents a Port.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class Ports {

    /**
     * The port code
     */
    private final int code;

    /**
     * The port name
     */
    private final String portName;

    /**
     * The port location
     */
    private final PlaceLocation coordinates;

    /**
     * The port country
     */
    private final Country country;

    /**
     * Build an instance of {@code Ports} by receiving the country, the code, the name and the coordinates
     * @param country The port country
     * @param code The port code
     * @param portName The port name
     * @param coordinates The port location
     */
    public Ports(Country country, int code, String portName, PlaceLocation coordinates){
        this.country=country;
        this.code=code;
        this.portName=portName;
        this.coordinates=coordinates;
    }

    /**
     * Get the port name
     * @return The port name
     */
    public String getPortName(){
        return portName;
    }

    /**
     * Get the port code
     * @return The port code
     */
    public int getCode(){
        return code;
    }

    /**
     * Get the latitude of the port
     * @return  The latitude of the port
     */
    public double getLatitude(){
        return coordinates.getLatitude();
    }

    /**
     * Get the longitude of the port
     * @return  The longitude of the port
     */
    public double getLongitude(){
        return coordinates.getLongitude();
    }

    /**
     * Get the country name to which the port belongs
     * @return The country name to which the port belongs
     */
    public String getCountryName(){
        return country.getCountryName();
    }

    /**
     * Get the continent to which the port belongs
     * @return The continent to which the port belongs
     */
    public String getContinent(){
        return country.getContinent();
    }

}
