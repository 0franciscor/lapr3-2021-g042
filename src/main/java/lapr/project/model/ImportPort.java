package lapr.project.model;


import lapr.project.controller.App;
import lapr.project.model.store.CountryStore;

import java.io.File;
import java.util.Scanner;

/**
 * The ImportPort class, which allows the user to import ports from a .csv file
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ImportPort {

    /**
     * Represents an instance of Company
     */
    private final Company company;

    /**
     * The file to be imported
     */
    File file;

    /**
     * The Scanner which reads the file
     */
    Scanner read;

    CountryStore str;

    Ports2DTree ports2DTree;


    /**
     * The class constructor
     */
    public ImportPort() {
        this.company=App.getInstance().getCompany();
        this.str=company.getCountryStr();
        this.ports2DTree=company.getPorts2DTree();
    }

    /**
     * The class constructor
     */
    public ImportPort(Company company) {
        this.company=company;
        this.str=company.getCountryStr();
        this.ports2DTree=company.getPorts2DTree();
    }

    /**
     * @param nameOfTheFileToBeImported The file name
     *
     * Allows the class to fetch the file desired by the user
     *
     * @return the success of the operation
     */
    public boolean loadFile(String nameOfTheFileToBeImported ){
        file = new File(nameOfTheFileToBeImported);
        if(file.exists()) {
            try {
                read = new Scanner(file);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public void convertPorts(){
        read.nextLine();
        while(read.hasNext()){
            String line = read.nextLine();
            String[] portArray = line.split(",");
            Country country = str.getCountryByName(portArray[1]);
            if(country == null){
                country = str.createCountry(portArray[1],portArray[0]);
                str.saveCountry(country);
            }
            PlaceLocation placeLocation = new PlaceLocation(Double.parseDouble(portArray[4]),Double.parseDouble(portArray[5]));
            Ports port = new Ports(country,Integer.parseInt(portArray[2]),portArray[3],placeLocation);
            ports2DTree.insert(port,Double.parseDouble(portArray[4]),Double.parseDouble(portArray[5]));
        }
        read.close();
    }

}
