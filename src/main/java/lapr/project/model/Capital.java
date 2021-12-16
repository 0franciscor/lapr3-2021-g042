package lapr.project.model;

/**
 * The Capital Class, which represents the capital of a country.
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class Capital {

    /**
     * The capital name.
     */
    private final String name;

    /**
     * The country capital.
     */
    private final String countryName;

    /**
     * The Coordinates of the capital.
     */
    private final PlaceLocation placeLocation;

    /**
     * The Capital Constructor
     *
     * @param name of the capital
     * @param countryName of the country
     * @param latitude of the capital
     * @param longitude of the capital
     */
    public Capital(String name, String countryName, String latitude, String longitude){
        this.name = name;
        this.countryName = countryName;
        this.placeLocation = new PlaceLocation(Double.parseDouble(latitude), Double.parseDouble(longitude));
    }

    /**
     * @return the name of the capital
     */
    public String getName(){
        return name;
    }

    /**
     * @return the capital's country
     */
    public String getCountryName(){
        return countryName;
    }

    /**
     * @return the Capital Latitude
     */
    public double getLatitude(){
        return placeLocation.getLatitude();
    }

    /**
     * @return the Capital Longitude
     */
    public double getLongitude(){
        return placeLocation.getLongitude();
    }
}
