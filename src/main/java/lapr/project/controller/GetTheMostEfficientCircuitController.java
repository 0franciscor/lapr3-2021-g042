package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Place;
import lapr.project.model.esinf.FreightNetwork;
import lapr.project.model.store.CountryStore;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetTheMostEfficientCircuitController {

    /**
     * Represents an instance of app.
     */
    private final App app;

    /**
     * Represents an instance of Company
     */
    private final Company company;

    private final FreightNetwork freightNetwork;

    /**
     * Represents an instance of Write for a file
     */
    private final WriteForAFile writeForAFile;

    public GetTheMostEfficientCircuitController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.freightNetwork=company.getFreightNetwork();
        this.writeForAFile = new WriteForAFile();
    }

    public LinkedList<Place> getTheMostEfficientCircuit(String origem) throws IOException {
        LinkedList<Place> result =freightNetwork.mostEfficientCircuit(origem);
        File file = new File(".\\outputs\\Efficient Circuit");
        writeForAFile.writeForAFile("", "Efficient Circuit",file,false);
        for (Place place : result){
            writeForAFile.writeForAFile(place +"\n" , "Efficient Circuit",file,true);
        }
        return result;
    }

}
