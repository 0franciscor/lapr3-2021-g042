package lapr.project.ui;

import lapr.project.controller.ImportShipController;
import lapr.project.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Francisco Redol
 */
public class ImportShipUI implements Runnable{

    private ImportShipController importShipController;


    public ImportShipUI(){
        importShipController = new ImportShipController();
    }

    @Override
    public void run() {

        String fileName;

        do {
            fileName = Utils.readLineFromConsole("\nPlease insert the name of the file: ");

        }while (!importShipController.importFile(fileName));
        System.out.println("Ships not imported: " + importShipController.importShips());

    }

}
