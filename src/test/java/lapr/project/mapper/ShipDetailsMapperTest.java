package lapr.project.mapper;

import lapr.project.controller.SearchDetailsController;
import lapr.project.mapper.dto.ShipDetailsDto;
import lapr.project.model.BstShip;
import lapr.project.model.Ship;
import lapr.project.model.ShipLocation;
import lapr.project.model.ShipLocationBST;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ShipDetailsMapperTest {

    Ship ship;

    ShipDetailsMapper mapper;

    ShipLocationBST<ShipLocation> tree;



    @Before
    public void setUp() throws ParseException {
        //ship = new Ship("211331640","SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,79,13,tree);

    }

    @Test
    public void toModel() {
        mapper = new ShipDetailsMapper();
        ShipDetailsDto ship1 = new ShipDetailsDto("211331640","SEOUL EXPRESS","IMO2113432","DHBN",70,294,32,13);
        ShipDetailsDto ship2 = mapper.toDto(ship);
        Assert.assertEquals(ship1, ship2);
    }

    @Test
    public void toDto() {
        mapper = new ShipDetailsMapper();
        ShipDetailsDto ship1 = new ShipDetailsDto("211331640","SEOUL EXPRESS","IMO2113432","DHBN",70,294,32,13);
        ShipDetailsDto ship2 = mapper.toDto(ship);

        Assert.assertEquals(ship1.getMMSI(),ship2.getMMSI());
        Assert.assertEquals(ship1.getName(),ship2.getName());
        Assert.assertEquals(ship1.getShipID(),ship2.getShipID());
        Assert.assertEquals(ship1.getCallSign(),ship2.getCallSign());
        Assert.assertEquals(ship1.getVesselType(), ship2.getVesselType(),0.0);
        Assert.assertEquals(ship1.getLength(), ship2.getLength(),0.0);
        Assert.assertEquals(ship1.getWidth(),ship2.getWidth(),0.0);
        Assert.assertEquals(ship.getDraft(), ship2.getDraft(),0.0);

    }
}