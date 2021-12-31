package lapr.project.model;

/**
 * The Capital Class, which represents the capital of a country.
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class Capital extends Place{

    /**
     * The capital name.
     */
    private final String name;

    /**
     * The Capital Constructor
     *
     * @param name of the capital
     * @param country of the capital
     * @param latitude of the capital
     * @param longitude of the capital
     */
    public Capital(String name, Country country, String latitude, String longitude){
        super(Double.parseDouble(latitude),Double.parseDouble(longitude), country.getCountryName(), country.getContinent());
        this.name = name;
    }

    /**
     * @return the name of the capital
     */
    public String getName(){
        return name;
    }

    /**
     * @return String representing the Capital Object
     */
    public String toString(){
        return String.format("Capital %s belongs to %s.", name, getCountryName());
    }
}
