package lapr.project.ui;

import lapr.project.controller.ImportShipController;

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

    private Scanner read;

    public ImportShipUI(){
        importShipController = new ImportShipController();
        read = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Please choose an option:\n\n");
        List<String> listOfOptions = new ArrayList<>();
        listOfOptions.add("Import Ships from a file.");
        listOfOptions.add("Exit to main menu.");

        int index = 1;
        for(String option : listOfOptions) {
            System.out.println(index + ". " + option);
            index++;
        }

        System.out.printf("\nPlease insert the name of the file: ");
        String fileName = read.next();

        importShipController.importFile(fileName);

    }

}
