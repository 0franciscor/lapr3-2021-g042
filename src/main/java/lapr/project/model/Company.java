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
     * Represents an instance of the importShip Class
     */
    private ImportShip importShip;

    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new BstShip();
        importShip = new ImportShip();
    }

    /**
     * Get the instance of BstShip
     * @return the bstShip
     */
    public BstShip getBstShip() {
        return bstShip;
    }

    /**
     * Get the instance of ImportShip
     * @return the ImportShip
     */
    public ImportShip getImportShip (){
        return importShip;
    }

}
