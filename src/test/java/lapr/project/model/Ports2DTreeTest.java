package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ports2DTreeTest {

    Ports2DTree portsEmpty = new Ports2DTree();
    Ports2DTree ports = new Ports2DTree();

    Ports port1;
    Ports port2;
    Ports port3;

    public Ports2DTreeTest(){
        Country country1=new Country("Europe","Denmark");
        PlaceLocation placeLocation1= new PlaceLocation(56.15,10.21666667);
        port1 = new Ports(country1,10358,"Aarhus",placeLocation1);
        ports.insert(port1,port1.getLatitude(),port1.getLongitude());
        PlaceLocation placeLocation2= new PlaceLocation(55.7,12.61666667);
        port2 = new Ports(country1,10358,"Aarhus",placeLocation2);
        ports.insert(port2,port2.getLatitude(),port2.getLongitude());
        Country country3=new Country("Europe","Russia");
        PlaceLocation placeLocation3= new PlaceLocation(59.88333333,30.21666667);
        port3 = new Ports(country3,18454,"St Petersburg",placeLocation3);
        ports.insert(port3,port3.getLatitude(),port3.getLongitude());
    }

    @Test
    void isEmpty() {
        assertTrue(portsEmpty.isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertFalse(ports.isEmpty());
    }

    @Test
    void rootNull(){
        assertNull(portsEmpty.root());
    }

    @Test
    void insert01() {
        Ports result = (Ports) ports.findNearestNeighbour(55.7, 12.61666667);
        assertEquals(port2, result);
    }

    @Test
    void insert02() {
        Ports result = (Ports) ports.findNearestNeighbour(56.15, 10.21666667);
        assertEquals(port1, result);
    }

    @Test
    void insert03() {
        Ports result = (Ports) ports.findNearestNeighbour(59.88333333, 30.21666667);
        assertEquals(port3, result);
    }

    @Test
    void findNearestNeighbour() {
    }
}