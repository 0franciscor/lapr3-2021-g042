package lapr.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CargoManifestTest {

    private CargoManifest cargoManifest;

    @BeforeEach
    void setUp() {
        cargoManifest = new CargoManifest(new Date(), 5, "211331640",CargoManifest.Destination.PORT);
    }

    @Test
    void getDate() {
        assertEquals(new Date(), cargoManifest.getDate());
    }

    @Test
    void getTotalNumberOfContainers() {
        assertEquals(5, cargoManifest.getTotalNumberOfContainers());
    }

    @Test
    void getMmsiCodeShip() {
        assertEquals("211331640", cargoManifest.getMmsiCodeShip());
    }

    @Test
    void getDestination() {
        assertEquals(CargoManifest.Destination.PORT, cargoManifest.getDestination());
    }
}