package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Place;
import lapr.project.model.esinf.FreightNetwork;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetShortestPathsController {
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

    public GetShortestPathsController(){
        this.app=App.getInstance();
        this.company=app.getCompany();
        this.freightNetwork=company.getFreightNetwork();
        this.writeForAFile = new WriteForAFile();
    }

    public ArrayList<List<Place>> getShortestPaths(String origem, String destino,List<String> passagensObrigatorias) throws IOException {
        ArrayList<List<Place>> result =freightNetwork.getShortestPaths(origem,destino,passagensObrigatorias);
        File file = new File(".\\outputs\\Shortest Paths");
        writeForAFile.writeForAFile("", "Shortest Paths",file,false);
        for (List<Place> place : result){
            writeForAFile.writeForAFile(place +"\n" , "Shortest Paths",file,true);
        }
        return result;
    }
}
