package lapr.project.controller;

import lapr.project.model.ImportShip;
import lapr.project.utils.WriteForAFile;

import java.io.File;

/**
 * The ImportShip Controller, controller responsible for managing the Import Ship class, which allows the Traffic manager to import ships from a .csv file
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class ImportShipController {

    /**
     * The ImportShip class
     */
    private final ImportShip importShip;

    /**
     * The file (which is being imported) name
     */
    private String fileName;

    /**
     * The class constructor
     */
    public ImportShipController(){
        this.importShip = new ImportShip();
    }

    /**
     * @param fileName The name of the file
     *
     * Allows importing of the file
     *
     * @return the success of the operation
     */
    public boolean importFile(String fileName){
        this.fileName = fileName;
       return importShip.getFile(fileName);
    }

    /**
     * Allows the system to import the ships.
     *
     * @return A number of ships which were not imported
     */
    public int importShips(){
        int numNavios = importShip.convertShips();

        try {
            new WriteForAFile().writeForAFile(String.format("%s : Ships not imported: %d.%n", fileName, numNavios), "Show_Not_Imported_Ships", new File("Ship Importing"));
        } catch (Exception e){
            System.out.println("There was an error when writing for a file the number of not imported ships.");
        }
        return numNavios;
    }
}
