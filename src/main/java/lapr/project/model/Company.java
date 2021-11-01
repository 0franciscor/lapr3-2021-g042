package lapr.project.model;


/**
 * Class that represents a company.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class Company {

    /**
     * Represents an instance of the BstShip
     */
    private BstShip bstShip;

    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new BstShip();
    }

    /**
     *  Get the instance of BstShip
     * @return the bstShip
     */
    public BstShip getBstShip() {
        return bstShip;
    }

}
