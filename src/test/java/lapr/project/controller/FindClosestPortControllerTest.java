package lapr.project.controller;

import lapr.project.model.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


class FindClosestPortControllerTest {

    ImportPortController controller = new ImportPortController();
    FindClosestPortController ctrlr = new FindClosestPortController();
    ImportShipController importShipController = new ImportShipController();


    @BeforeEach
    public void setUp(){
        importShipController.importFile("sships.csv");
        importShipController.importShips();
        controller.importFile("bports.csv");
        controller.importPorts();
    }

    /*
    @Test
    void findClosestPort() throws ParseException {
        Country country = new Country("America","Canada");
        PlaceLocation placeLocation = new PlaceLocation(44.65,-63.56666667);
        Ports expected = new Ports(country,22226,"Halifax",placeLocation);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Ports port = ctrlr.findClosestPort("C4SQ2",dateFormatter.parse("31-12-2020 17:19"));
        Assert.assertEquals(expected,port);
    }
     */


    /*
    @Test
    void findClosestPortNotExist() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Ports port = ctrlr.findClosestPort("00002",dateFormatter.parse("31-12-2020 17:19"));
        Assert.assertNull(port);
    }

     */

}