package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceLocationTest {
    PlaceLocation location;

    public PlaceLocationTest(){
       location = new PlaceLocation(56.15,10.21666667);
    }

    @Test
    void getLatitude() {
        double expected = 56.15;
        assertEquals(expected,location.getLatitude());
    }

    @Test
    void getLongitude() {
        double expected = 10.21666667;
        assertEquals(expected,location.getLongitude());
    }
}