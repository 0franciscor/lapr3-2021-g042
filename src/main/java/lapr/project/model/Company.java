package lapr.project.model;

import auth.AuthFacade;

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
     *
     */
    private AuthFacade authFacade;


    /**
     * Creates an instance of Company
     */
    public Company(){
        bstShip = new AvlShip();
        importShip = new ImportShip();
        authFacade = new AuthFacade();
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
     *
     * @return
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }
}
