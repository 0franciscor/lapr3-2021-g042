package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortsTest {

    Ports port;

    public PortsTest(){
        Country country1=new Country("Europe","Denmark");
        PlaceLocation placeLocation1= new PlaceLocation(56.15,10.21666667);
        port = new Ports(country1,10358,"Aarhus",placeLocation1);
    }

    @Test
    void getPortName() {
        String expected = "Aarhus";
        assertEquals(expected,port.getPortName());
    }

    @Test
    void getCode() {
        int expected = 10358;
        assertEquals(expected,port.getCode());
    }

    @Test
    void getLatitude() {
        double expected = 56.15;
        assertEquals(expected,port.getLatitude());
    }

    @Test
    void getLongitude() {
        double expected = 10.21666667;
        assertEquals(expected,port.getLongitude());
    }

    @Test
    void getCountryName() {
        String expected = "Denmark";
        assertEquals(expected,port.getCountryName());
    }

    @Test
    void getContinent() {
        String expected = "Europe";
        assertEquals(expected,port.getContinent());
    }
}