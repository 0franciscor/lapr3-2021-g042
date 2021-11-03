package lapr.project.controller;

import lapr.project.model.ImportShip;

public class ImportShipController {

    private ImportShip importShip;

    public ImportShipController(){
        //importShip = new App.getCompany().getImportShip(); //mudar para Company
        importShip = new ImportShip();
    }

    public boolean importFile(String fileName){
       return importShip.getFile(fileName);
    }

    public int importShips(){
        int shipsNotConverted = importShip.convertShips();

        return shipsNotConverted;
    }
}
