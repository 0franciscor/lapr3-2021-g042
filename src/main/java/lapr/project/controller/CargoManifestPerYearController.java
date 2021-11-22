package lapr.project.controller;

import lapr.project.model.BstShip;
import lapr.project.model.CargoManifest;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.store.CargoManifestStore;

import java.util.ArrayList;
import java.util.List;

/**
 * The CargoManifestPerYear Controller, the controller responsible for managing the CargoManifest class, which allows the Ship Captain to now information about the cargo manifest
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class CargoManifestPerYearController {

    /**
     * Represents an instance of company
     */
    private Company company;

    /**
     * Represents an instance of bstShip
     */
    private BstShip bstShip;

    /**
     * Represents an instance of cargoManifestStore
     */
    private CargoManifestStore cargoManifestStore;

    /**
     * Represents a list of cargo manifests
     */
    private List<CargoManifest> cargoManifestList;

    /**
     * Initialize the controller
     */
    public CargoManifestPerYearController(){
        company = App.getInstance().getCompany();
        bstShip = company.getBstShip();
        cargoManifestStore = company.getCargoManifestStore();
        cargoManifestList = new ArrayList<>();
    }

    public CargoManifestPerYearController(Company company){
        this.company = company;
        bstShip = company.getBstShip();
        cargoManifestStore = company.getCargoManifestStore();
        cargoManifestList = new ArrayList<>();
    }

    /**
     * Get the mean number of container per manifest of a ship
     * @param mmsiCode the mmsi code of a ship
     * @return the mean number of container per cargo manifest
     */
    public float getNumberOfContainerPerManifest(String mmsiCode){
        if (shipExist(mmsiCode)) {

            List<CargoManifest> cargoManifests = initializeListOfCargoManifest(mmsiCode);
            return cargoManifestStore.getMeanContainersPerCargoManifest(cargoManifests);
        }
        return 0;
    }

    /**
     * Get the number of cargo manifest per year of a ship
     * @param mmsiCode the mmsi code of a ship
     * @param year the year of the cargo manifest
     * @return the number of cargo manifests per year
     */
    public int getTheCargoManifestPerYear(String mmsiCode, int year){
        if (shipExist(mmsiCode)) {
            List<CargoManifest> cargoManifests = initializeListOfCargoManifest(mmsiCode);
            return cargoManifestStore.getTheCargoManifestPerYear(cargoManifests, year);
        }
        return 0;
    }

    /**
     * Initializes the list of cargo manifests related with a ship
     * @param mmsiCode the mmsi code of a ship associated with the cargo manifest
     */
    private List<CargoManifest> initializeListOfCargoManifest(String mmsiCode){
        return cargoManifestStore.getCargoManifestByMmsiCode(mmsiCode);
    }
    /**
     * Verification if a ship exists in the system through the MMSI code
     * @param mmsiCode Code of the ship that we want to know if it exists in the system
     * @return true if the ship exists, otherwise return false
     */
    private boolean shipExist(String mmsiCode){
        if (mmsiCode == null) return false;
        Ship ship = bstShip.getShipByMmsiCode(mmsiCode);
        return ship != null;
    }
}
