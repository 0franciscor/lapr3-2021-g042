package lapr.project.controller;

import lapr.project.model.ImportShip;

/**
 * The ImportShip Controller
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class ImportShipController {

    /**
     * The ImportShip class
     */
    private ImportShip importShip;

    /**
     * The class constructor
     */
    public ImportShipController(){
        //importShip = new App.getCompany().getImportShip(); //mudar para Company
        importShip = new ImportShip();
    }

    /**
     * @param fileName The name of the file
     *
     * Allows importing of the file
     *         .
     * @return the success of the operation
     */
    public boolean importFile(String fileName){
       return importShip.getFile(fileName);
    }

    /**
     * Allows the system to import the ships.
     *
     * @return A number of ships which were not imported
     */
    public int importShips(){
        int shipsNotConverted = importShip.convertShips();
        return shipsNotConverted;
    }
}
