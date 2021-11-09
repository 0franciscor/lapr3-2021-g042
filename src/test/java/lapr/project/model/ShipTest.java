package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ShipTest {

    @Test
    void setMMSI() {
        Ship ship = new Ship();
        ship.setMMSI("123456789");

        assertEquals("123456789", ship.getMMSI());
    }

    @Test
    void setMMSIWrong() {
        boolean exception = false;
        Ship ship = new Ship();
        try{
            ship.setMMSI("12345678");
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    void setName() {
        Ship ship = new Ship();
        ship.setName("NavioBom");
        assertEquals("NavioBom", ship.getName());
    }

    @Test
    void setNameWrong(){
        boolean exception = false;
        Ship ship = new Ship();
        try{
            ship.setName("");
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);

    }

    @Test
    void setShipID() {
        Ship ship = new Ship();
        ship.setShipID("IMO1234567");
        assertEquals("IMO1234567", ship.getShipID());
    }

    @Test
    void setShipIDWrong(){
        boolean exception = false;
        Ship ship = new Ship();
        try{
            ship.setShipID("IMO123456");
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);

    }

    @Test
    void setNumberGenerators() {
        Ship ship = new Ship();
        ship.setNumberGenerators(5);
        assertEquals(5, ship.getEnergyGenerators());
    }

    @Test
    void setNumberGeneratorsWrong(){
        boolean exception = false;
        Ship ship = new Ship();
        try{
            ship.setNumberGenerators(-4);
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    void setGeneratorOutput() {
        Ship ship = new Ship();
        ship.setGeneratorOutput(18f);
        assertEquals(18f, ship.getGeneratorOutput(), 0);
    }

    @Test
    void setGeneratorOutputWrong() {
        boolean exception = false;
        Ship ship = new Ship();

        try{
            ship.setGeneratorOutput(-4f);
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    void setCallSign() {
        Ship ship = new Ship();
        ship.setCallSign("callSign");
        assertEquals("callSign", ship.getCallSign());
    }

    @Test
    void setCallSignWrong(){
        boolean exception = false;
        Ship ship = new Ship();

        try{
            ship.setCallSign("");
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    void setCapacityNA() {
        Ship ship = new Ship();
        ship.setCapacity("NA");
        assertEquals("NA", ship.getCapacity());
    }

    @Test
    void setCapacity(){
        Ship ship = new Ship();
        ship.setCapacity("18");
        assertEquals("18", ship.getCapacity());
    }

    @Test
    void setCapacityWrong(){
        boolean exception = false;
        Ship ship = new Ship();

        try{
            ship.setCapacity("Autocarro");
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    void setVesselType() {
        Ship ship = new Ship();
        ship.setVesselType(63, 9f, 5f, 6f);

        assertEquals(63, ship.getVesselType(), 0);
        assertEquals(9f, ship.getLength(), 0);
        assertEquals(5f, ship.getWidth(), 0);
        assertEquals(6f, ship.getDraft(), 0);
    }

    @Test
    void setVesselTypeWrong(){
        boolean exception = false;
        Ship ship = new Ship();

        try{
            ship.setVesselType(53, -29f, -55f, -5f);
        } catch (Exception e){
            exception = true;
        }
        assertTrue(exception);
    }

//    @Test
//    void getMMSI() {
//    }
//
//    @Test
//    void getName() {
//    }
//
//    @Test
//    void getShipID() {
//    }
//
//    @Test
//    void getEnergyGenerators() {
//    }
//
//    @Test
//    void getGeneratorOutput() {
//    }
//
//    @Test
//    void getCallSign() {
//    }
//
//    @Test
//    void getVesselType() {
//    }
//
//    @Test
//    void getLength() {
//    }
//
//    @Test
//    void getWidth() {
//    }
//
//    @Test
//    void getCapacity() {
//    }
//
//    @Test
//    void getDraft() {
//    }
//
//    @Test
//    void getShipPosition() {
//    }

    @Test
    void compareToEquals() {
        Ship ship = new Ship("123456789", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());
        Ship ship2 = new Ship("123456789", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());

        assertEquals(0, ship.compareTo(ship2));
    }

    @Test
    void compareToBigger() {
        Ship ship = new Ship("123456790", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());
        Ship ship2 = new Ship("123456789", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());

        assertEquals(1, ship.compareTo(ship2));
    }

    @Test
    void compareToSmaller() {
        Ship ship = new Ship("123456789", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());
        Ship ship2 = new Ship("123456790", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());

        assertEquals(-1, ship.compareTo(ship2));
    }

//    @Test
//    void testToString() {
//        Ship ship = new Ship("123456789", "Navio", "IMO1234567", 3, 5f, "CHAMAMENTO", 583, 18f, 9f, "23", 9f, new ShipLocation());
//        assertEquals("MMSI: 123456789\nName: Navio\nshipID: IMO1234567\nEnergy Generators: 3\nGenerator Output: 5,00\nCall Sign: CHAMAMENTO\nVessel Type: 583\nLength: 18,00\nWidth: 9,00\nCapacity: 23\nDraft: 9,00\n", ship.toString());
//    }

}