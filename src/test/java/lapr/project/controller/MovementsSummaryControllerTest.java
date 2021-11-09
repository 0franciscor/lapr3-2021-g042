package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipLocation;
import lapr.project.model.ShipLocationBST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovementsSummaryControllerTest {

    MovementsSummaryController movementsSummaryController;

    List<ShipLocation> arr = new ArrayList<>();

    String[] auxDatas = {"31-12-2020 01:25","31-12-2020 16:15","31-12-2020 17:02"};

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    ShipLocationBST<ShipLocation> tree;

    ShipLocation location1;
    ShipLocation location2;
    ShipLocation location3;

    ShowPositionalMessagesController controller;

    public MovementsSummaryControllerTest() throws ParseException {
        location1 = new ShipLocation("211331640", dateFormatter.parse(auxDatas[0]), "36", "-122", 19, 145, "147", "B");
        location2 = new ShipLocation("211331640", dateFormatter.parse(auxDatas[1]), "36", "-122", 19, 145, "147", "B");
        location3 = new ShipLocation("211331640", dateFormatter.parse(auxDatas[2]), "36", "-122", 19, 145, "147", "B");
        arr.add(location1);
        arr.add(location2);
        arr.add(location3);
    }

    @BeforeEach
    public void setUp(){
        ImportShipController impShipCTR = new ImportShipController();
        impShipCTR.importFile("sships.csv");
        impShipCTR.importShips();
        movementsSummaryController = new MovementsSummaryController();
    }

    /*@Test
    void getShipByMmsiCode() {
        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,"79",13,tree);
        assertEquals(ship, movementsSummaryController.getShipByMmsiCode("211331640"));
    }*/

    @Test
    void createSummaryForShip() {
    }

    @Test
    void createSummaryDto() {
    }

    @Test
    void shipExist() {
    }

    @Test
    void writeForAFile() {
    }
}