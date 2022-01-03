package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.store.*;
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
    }

    @Test
    void createFreightNetworkCompany() {
        CreateFreightNetworkController controller = new CreateFreightNetworkController(new Company());
    }




}