package lapr.project.controller;

import lapr.project.model.CargoManifest;
import lapr.project.model.Company;
import lapr.project.model.store.CargoManifestStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CargoManifestPerYearControllerTest {

    private CargoManifestPerYearController cargoManifestPerYearController;

    private CargoManifestStore cargoManifestStore;

    @Test
    void cargoManifestPerYearControllerTest(){
        cargoManifestPerYearController = new CargoManifestPerYearController();
    }

   /* @BeforeEach
    void setUp() {
        Company company = new Company();
        ImportShipController impShipCTR = new ImportShipController(company);
        impShipCTR.importFile("sships.csv");
        impShipCTR.importShips();
        cargoManifestPerYearController = new CargoManifestPerYearController(company);
        cargoManifestStore = company.getCargoManifestStore();
    }

    @Test
    void getNumberOfContainerPerManifest() {
        CargoManifest cargoManifest = new CargoManifest(new Date(2021, Calendar.NOVEMBER, 13), 10, "210950000", CargoManifest.Destination.PORT);
        cargoManifestStore.saveCargoManifest(cargoManifest);
        assertEquals(10, cargoManifestPerYearController.getNumberOfContainerPerManifest("210950000"));
    }

    @Test
    void getTheCargoManifestPerYear() {
        CargoManifest cargoManifest = new CargoManifest(new Date(2021, Calendar.NOVEMBER, 13), 10, "210950000", CargoManifest.Destination.PORT);
        CargoManifest cargoManifest1 = new CargoManifest(new Date(2021, Calendar.NOVEMBER, 14), 10, "210950000", CargoManifest.Destination.PORT);
        CargoManifest cargoManifest2 = new CargoManifest(new Date(2021, Calendar.NOVEMBER, 15), 10, "210950000", CargoManifest.Destination.PORT);
        CargoManifest cargoManifest3 = new CargoManifest(new Date(2021, Calendar.NOVEMBER, 16), 10, "210950000", CargoManifest.Destination.PORT);
        cargoManifestStore.saveCargoManifest(cargoManifest);
        cargoManifestStore.saveCargoManifest(cargoManifest1);
        cargoManifestStore.saveCargoManifest(cargoManifest2);
        cargoManifestStore.saveCargoManifest(cargoManifest3);

        assertEquals(4, cargoManifestPerYearController.getTheCargoManifestPerYear("210950000", 2021));
    }*/
}