package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Place;
import lapr.project.model.esinf.FreightNetwork;
import lapr.project.model.store.CountryStore;
import lapr.project.utils.WriteForAFile;

import java.util.LinkedList;

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

}
