package lapr.project.controller;

import lapr.project.mapper.ShipDetailsMapper;
import lapr.project.mapper.dto.ShipDetailsDto;
import lapr.project.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchDetailsControllerTest {

    Company company;
    Company comp;
    Company com;
    Company co;
    Company c;

    SearchDetailsController controller;

    @Before
    public void setUp(){
        company = App.getInstance().getCompany();
        ImportShipController impShipCTR = new ImportShipController();
        impShipCTR.importFile("sships.csv");
        controller = new SearchDetailsController();
    }


    /*Ship existingShip1 = new Ship("210950000","VARAMO","IMO9395044","C4SQ2",70,166f,25f,9.5f);
    ShipDetailsDto existingShip2 = new ShipDetailsDto("212180000","SAITA I","IMO9643544","5BBA4",70,228f,32f,14.4f);
    ShipDetailsDto existingShip3 = new ShipDetailsDto("212351000","HYUNDAI SINGAPORE","IMO9305685","5BZP3",70,303f,40f,14.5f);

    ShipDetailsDto notExistingShip = new ShipDetailsDto("210951111","BARAMO","IMO9999999","W3WQ2",66,298f,26f,9.9f);
    */

   @Test
    public void shipExistByMMSI() {
       comp=new Company();

       SearchDetailsController ctr = new SearchDetailsController(comp);

       ShipLocationBST<ShipLocation> tree;
       List<ShipLocation> arr = new ArrayList<>();

       tree = new ShipLocationBST();
       for(ShipLocation i :arr)
           tree.insert(i);
       Ship ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,"79",13,tree);
       comp.getBstShip().insert(ship);
        boolean result = ctr.shipExistByMMSI("211331640");
        System.out.println(result);
        assertTrue(result);
    }


    @Test
    public void shipNotExistByMMSI() {
        boolean result = controller.shipExistByMMSI("210951111");
        assertFalse(result);
    }

    @Test
    public void shipExistByIMO() {
        com=new Company();

        SearchDetailsController ctr = new SearchDetailsController(com);

        ShipLocationBST<ShipLocation> tree;
        List<ShipLocation> arr = new ArrayList<>();

        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,"79",13,tree);
        com.getBstShip().insert(ship);

        Ship result = ctr.shipExistByIMO("IMO2113432");
        boolean flag;
        if (result == null) flag = true;
        else flag = false;
        assertFalse(flag);
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
        co=new Company();

        SearchDetailsController ctr = new SearchDetailsController(co);

        ShipLocationBST<ShipLocation> tree;
        List<ShipLocation> arr = new ArrayList<>();

        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,"79",13,tree);
        co.getBstShip().insert(ship);

        Ship result = ctr.shipExistByCallSign("DHBN");
        boolean flag;
        if (result == null) flag = true;
        else flag = false;
        assertFalse(flag);
    }

    @Test
    public void shipNotExistByCallSign() {
        Ship result = controller.shipExistByCallSign("W3WQ2");
        boolean flag;
        if (result != null) flag = false;
        else flag = true;
        assertTrue(flag);
    }


    @Test
    public void getShipDetails() {
        c=new Company();

        SearchDetailsController ctr = new SearchDetailsController(c);

        ShipLocationBST<ShipLocation> tree;
        List<ShipLocation> arr = new ArrayList<>();

        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,"79",13,tree);
        c.getBstShip().insert(ship);
        String expected = "MMSI: 211331640 \n" +
                 "Name: SEOUL EXPRESS \n" +
                 "IMO: IMO2113432 \n" +
                 "Call Sign: DHBN \n" +
                 "Vessel Type: 70 \n" +
                 "Length: 294.0 \n" +
                 "Width: 32.0 \n" +
                 "Draft: 13.0";
        ctr.shipExistByIMO("IMO2113432");
        assertEquals(expected, ctr.getShipDetails());
    }
}