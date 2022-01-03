package lapr.project.controller;

import lapr.project.model.Capital;
import lapr.project.model.Company;
import lapr.project.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateFreightNetworkControllerTest {

    CreateFreightNetworkController createFreightNetworkController;

    @BeforeEach
    void setUp() {
       createFreightNetworkController = new CreateFreightNetworkController();
    }


    @Test
    void createFreightNetwork() {
        createFreightNetworkController.createFreightNetwork(5);
        assertEquals(78,createFreightNetworkController.getPortStore().getPortsLst().size());
        assertEquals(2848,createFreightNetworkController.getSeadistStore().getSeadistLst().size());
        assertEquals(68,createFreightNetworkController.getCapitalStore().getCapitalLst().size());
        assertEquals(121,createFreightNetworkController.getBorderStore().getBorderLst().size());
    }

    @Test
    void createFreightNetworkCompany() {
        CreateFreightNetworkController controller = new CreateFreightNetworkController(new Company());
    }




}