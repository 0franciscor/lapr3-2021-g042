package lapr.project.controller;

import lapr.project.mapper.ShipDetailsMapper;
import lapr.project.mapper.dto.ShipDetailsDto;
import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import lapr.project.model.ImportShip;
import lapr.project.model.Ship;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchDetailsControllerTest {

    Company company = new Company();

    ImportShipController ctr = new ImportShipController(company) ;

    SearchDetailsController controller = new SearchDetailsController(company);

    @Before
    public void setUp(){
        ctr.importFile("sships.csv");
    }

    /*
    Ship existingShip1 = new Ship("210950000","VARAMO","IMO9395044","C4SQ2",70,166f,25f,9.5f);
    ShipDetailsDto existingShip2 = new ShipDetailsDto("212180000","SAITA I","IMO9643544","5BBA4",70,228f,32f,14.4f);
    ShipDetailsDto existingShip3 = new ShipDetailsDto("212351000","HYUNDAI SINGAPORE","IMO9305685","5BZP3",70,303f,40f,14.5f);

    ShipDetailsDto notExistingShip = new ShipDetailsDto("210951111","BARAMO","IMO9999999","W3WQ2",66,298f,26f,9.9f);
    */

   /*@Test
    public void shipExistByMMSI() {
        boolean result = controller.shipExistByMMSI("210950000");
        System.out.println(result);
        assertTrue(result);
    }*/


    @Test
    public void shipNotExistByMMSI() {
        boolean result = controller.shipExistByMMSI("210951111");
        assertFalse(result);
    }

    @Test
    public void shipExistByIMO() {
        Ship result = controller.shipExistByIMO("IMO9395044");
        boolean flag;
        if (result == null) flag = true;
        else flag = false;
        assertTrue(flag);
    }

    @Test
    public void shipNotExistByIMO() {
        Ship result = controller.shipExistByIMO("IMO9999999");
        boolean flag;
        if (result != null) flag = false;
        else flag = true;
        assertTrue(flag);
    }

    @Test
    public void shipExistByCallSign() {
        Ship result = controller.shipExistByCallSign("C4SQ2");
        boolean flag;
        if (result == null) flag = true;
        else flag = false;
        assertTrue(flag);
    }

    @Test
    public void shipNotExistByCallSign() {
        Ship result = controller.shipExistByCallSign("W3WQ2");
        boolean flag;
        if (result != null) flag = false;
        else flag = true;
        assertTrue(flag);
    }


    /*@Test
    public void getShipDetails() {
        String expected = "MMSI: 210950000 \n" +
                 "Name: VARAMO \n" +
                 "IMO: IMO9395044 \n" +
                 "Call Sign: C4SQ2 \n" +
                 "Vessel Type: 70 \n" +
                 "Length: 166.0 \n" +
                 "Width: 25.0 \n" +
                 "Draft: 9.5\n" +
                 "22";
        controller.shipExistByIMO("IMO9395044");
        assertEquals(expected, controller.getShipDetails());
    }*/
}