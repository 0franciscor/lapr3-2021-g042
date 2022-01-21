package lapr.project.model.lapr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipSankTest {

    private ShipSank shipSank;


    @Test
    public void vesselVolumeUnloaded() {
        shipSank = new ShipSank();
        shipSank.shipSankHeight(152*Math.pow(10, 6), 42, 342, 0);
        shipSank.getVesselEmptyVolume();
        shipSank.getVesselLoadedVolume();
        shipSank.getShipSankHeight();

        double result = shipSank.getVesselEmptyVolume();
        double expected = 1.4757281553398058 * Math.pow(10, 8);
        assertEquals(result, expected);
    }

    @Test
    public void vesselVolumeLoaded() {
        shipSank = new ShipSank();
        shipSank.shipSankHeight(152*Math.pow(10, 6), 42, 342, 10000);
        shipSank.getVesselEmptyVolume();
        shipSank.getVesselLoadedVolume();
        shipSank.getShipSankHeight();

        double result = shipSank.getVesselEmptyVolume();
        double expected = 1.4757281553398058 * Math.pow(10, 8);
        assertEquals(result, expected);
    }
}