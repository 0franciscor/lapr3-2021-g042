package lapr.project.model;

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
    private BstShip bstShip;

    /**
     * Represents an instance of the importShip Class
     */
    private ImportShip importShip;

    /**
     * Stores a list of vessels from imported ships which could be later used and more
     */
    private List<VesselType> vesselTypeList;

    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new BstShip();
        importShip = new ImportShip();
        vesselTypeList = new ArrayList<>();
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
     * Get the List of Vessel Types
     * @return vesselTypeList
     */
    public List<VesselType> getVesselTypeList(){
        return vesselTypeList;
    }

}
