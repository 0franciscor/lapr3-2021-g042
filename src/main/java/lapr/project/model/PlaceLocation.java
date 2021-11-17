package lapr.project.model;

/**
 * Represents a PlaceLocation.
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class PlaceLocation {

    /**
     * The latitude of the place
     */
    private final double latitude;

    /**
     * The longitude of the place
     */
    private final double longitude;

    /**
     * Build an instance of {@code PlaceLocation} by receiving the latitude and the longitude
     * @param latitude The latitude of the place
     * @param longitude The longitude of the place
     */
    public PlaceLocation(double latitude, double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }

    /**
     * Get the latitude of the place
     * @return The latitude of the place
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * Get the longitude of the place
     * @return The longitude of the place
     */
    public double getLongitude(){
        return longitude;
    }

}
