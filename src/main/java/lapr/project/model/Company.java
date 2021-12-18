package lapr.project.model;

import lapr.project.data.TransferFromDataBase;
import lapr.project.data.login.AuthFacade;
import lapr.project.model.store.CargoManifestStore;
import lapr.project.model.store.CountryStore;
import lapr.project.model.store.PortStore;

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

    private AuthFacade authFacade;

    /**
     * Represents an instance of the TransferFromDataBase object
     */
    private TransferFromDataBase transferFromDataBase;

    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new AvlShip();
        countryStr = new CountryStore();
        portStr = new PortStore();
        cargoManifestStore = new CargoManifestStore();
        authFacade=new AuthFacade();
    }

    /**
     * Get the instance of Cargo Manifest store
     * @return the cargo manifest store
     */
    public CargoManifestStore getCargoManifestStore() {
        return cargoManifestStore;
    }

    public AuthFacade getAuthFacade(){return authFacade;}
    /**
     * Get the instance of BstShip
     * @return the bstShip
     */
    public BstShip getBstShip() {
        return bstShip;
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

    /**
     * Returns an instance of the object which allows the Java system to import data from the database
     *
     * @return an instance of the GetTransferFromDatabase Object
     */
    public TransferFromDataBase getTransferFromDatabase(){
        if(transferFromDataBase == null)
            this.transferFromDataBase = new TransferFromDataBase();

        return transferFromDataBase;
    }

}
