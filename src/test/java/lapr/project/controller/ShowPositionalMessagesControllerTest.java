package lapr.project.controller;

import lapr.project.model.*;
import org.junit.Before;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShowPositionalMessagesControllerTest {

    List<ShipLocation> arr = new ArrayList<>();

    String[] auxDatas = {"31-12-2020 01:25","31-12-2020 16:15","31-12-2020 17:02"};

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    ShipLocationBST<ShipLocation> tree;

    ShipLocation location1;
    ShipLocation location2;
    ShipLocation location3;

    Company company;

    ShowPositionalMessagesController controller;

    public ShowPositionalMessagesControllerTest() throws ParseException {
        location1 = new ShipLocation(dateFormatter.parse(auxDatas[0]), "36", "-122", 19, 145, "147", "B");
        location2 = new ShipLocation(dateFormatter.parse(auxDatas[1]), "36", "-122", 19, 145, "147", "B");
        location3 = new ShipLocation(dateFormatter.parse(auxDatas[2]), "36", "-122", 19, 145, "147", "B");
        arr.add(location1);
        arr.add(location2);
        arr.add(location3);
    }

    @Before
    public void setUp(){
        company=new Company();
        controller = new ShowPositionalMessagesController(company);
        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,79,13,tree);
        company.getBstShip().insert(ship);
    }

    @org.junit.Test
    public void shipExist() {
        boolean result = controller.shipExist("211331640");
        assertTrue(result);
    }

    @org.junit.Test
    public void shipNotExist() {
        boolean result = controller.shipExist("211331650");
        assertFalse(result);
    }

    @org.junit.Test
    public void showPositionalMessages() {
    }
}