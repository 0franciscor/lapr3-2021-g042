package lapr.project.model;

import lapr.project.model.store.CountryStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a company.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class Company {

    /**
     * Represents an instance of the BstShip
     */
    private final BstShip bstShip;

    /**
     * Represents an instance of the importShip Class
     */
    private final ImportShip importShip;


    /**
     * List containing all countries existing in the Company.
     */
    private final CountryStore countryStr;

    /**
     * Represents an instance of the Ports2DTree
     */
    private final Ports2DTree ports2DTree;


    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new AvlShip();
        importShip = new ImportShip();
        countryStr = new CountryStore();
        ports2DTree = new Ports2DTree();
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

    /**
     * Get the store containing all countries existing in the Company.
     * @return The store containing all countries existing in the Company.
     */
    public CountryStore getCountryStr() { return countryStr; }

    /**
     * Get the instance of Ports2DTree
     * @return The Ports2DTree
     */
    public Ports2DTree getPorts2DTree() { return ports2DTree; }
}
