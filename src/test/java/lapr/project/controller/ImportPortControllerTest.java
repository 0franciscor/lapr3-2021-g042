package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.store.PortStore;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImportPortControllerTest {

    ImportPortController controller;

    Company company;

    @BeforeEach
    public void setUp(){
        company = new Company();
        controller = new ImportPortController(company);
    }

    @Test
    void importFile() {
        String fileName = "bports.csv";
        boolean result = controller.importFile(fileName);
        assertTrue(result);
    }

    @Test
    public void importFileInsuccess() {
        String fileName = "bports.csa";
        boolean result = controller.importFile(fileName);
        assertFalse(result);
    }

    @Test
    void importPorts() {
        String fileName = "bports.csv";
        controller.importFile(fileName);
        controller.importPorts();
        PortStore portStore =controller.getImportPort().getPortStore();
        Country country1=new Country("Europe","Denmark");
        PlaceLocation placeLocation1= new PlaceLocation(56.15,10.21666667);
        Ports port = new Ports(country1,10358,"Aarhus",placeLocation1);
        Assert.assertFalse(portStore.savePort(port));
    }
}