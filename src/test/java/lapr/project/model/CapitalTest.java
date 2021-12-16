package lapr.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalTest {

    private Capital capitalTest;

    @BeforeEach
    void setUp() {
        capitalTest = new Capital("Lisboa", "Portugal", "38.72", "-9.14");
    }

    @Test
    void getName() {
        String result = capitalTest.getName();
        assertEquals("Lisboa", result);
    }

    @Test
    void getCountryName() {
        String result = capitalTest.getCountryName();
        assertEquals("Portugal", result);
    }

    @Test
    void getLatitude() {
        double latitude = capitalTest.getLatitude();
        assertEquals(38.72, latitude, 0);
    }

    @Test
    void getLongitude() {
        double longitude = capitalTest.getLongitude();
        assertEquals(-9.14, longitude, 0);
    }
}