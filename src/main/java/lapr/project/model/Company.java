package lapr.project.model;

import lapr.project.model.store.CargoManifestStore;
import lapr.project.model.store.CountryStore;
import lapr.project.model.store.PortStore;

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
     * List containing all ports existing in the Company.
     */
    private final PortStore portStr;

    /**
     * Represents an instance of Cargo Manifest Store
     */
    private final CargoManifestStore cargoManifestStore;

    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new AvlShip();
        importShip = new ImportShip();
        countryStr = new CountryStore();
        portStr = new PortStore();
        cargoManifestStore = new CargoManifestStore();
    }

    /**
     * Get the instance of Cargo Manifest store
     * @return the cargo manifest store
     */
    public CargoManifestStore getCargoManifestStore() {
        return cargoManifestStore;
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
     * Get the store containing all ports existing in the Company.
     * @return The store containing all ports existing in the Company.
     */
    public PortStore getPortStr() { return portStr; }

}
