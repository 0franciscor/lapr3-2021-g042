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
     * The capital's Country.
     */
    private final Country country;

    /**
     * The Coordinates of the capital.
     */
    private final PlaceLocation placeLocation;

    /**
     * The Capital Constructor
     *
     * @param name of the capital
     * @param country of the capital
     * @param latitude of the capital
     * @param longitude of the capital
     */
    public Capital(String name, Country country, String latitude, String longitude){
        this.name = name;
        this.country = country;
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
        return country.getCountryName();
    }

    /**
     * @return the capital's Continent
     */
    public String getContinent(){
        return country.getContinent();
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
