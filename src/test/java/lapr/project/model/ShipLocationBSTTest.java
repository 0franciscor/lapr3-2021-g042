package lapr.project.model;

import lapr.project.controller.App;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import static org.junit.Assert.assertEquals;

public class ShipLocationBSTTest {


    List<ShipLocation> arr = new ArrayList<>();

    String[] auxDatas = {"31-12-2020 01:25","31-12-2020 16:15","31-12-2020 17:02", "12-12-2020 17:02"};

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    ShipLocationBST<ShipLocation> tree;

    ShipLocation location1;
    ShipLocation location2;
    ShipLocation location3;
    ShipLocation location4;

    Company company;

    public ShipLocationBSTTest() throws ParseException {
        location1 = new ShipLocation(dateFormatter.parse(auxDatas[0]),"36","-122",19,145,"147","B");
        location2 = new ShipLocation(dateFormatter.parse(auxDatas[1]),"36","-122",19,145,"147","B");
        location3 = new ShipLocation(dateFormatter.parse(auxDatas[2]),"36","-122",19,145,"147","B");
        location4 = new ShipLocation(dateFormatter.parse(auxDatas[3]),"36","-122",19,145,"147","B");
        arr.add(location1);
        arr.add(location2);
        arr.add(location3);
        arr.add(location4);
        company = App.getInstance().getCompany();
    }

    @Before
    public void setUp(){
        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640",",SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,79,13,tree);
    }

    @Test
    public void getPositionalMessagesNotExist01() throws ParseException {
        String[] datas = {"30-12-2020 01:25","30-12-2020 17:02"};
        List<String> expected = new ArrayList<>();
        List<String> result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }

    @Test
    public void getPositionalMessagesNotExist02() throws ParseException {
        String[] datas = {"31-12-2020 18:25","31-12-2020 20:02"};
        List<String> expected = new ArrayList<>();
        List<String> result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }

    @Test
    public void getPositionalMessagesExist01() throws ParseException {
        String[] datas = {"31-12-2020 01:25","31-12-2020 02:02"};
        List<String> expected = new ArrayList<>();
        expected.add(location1.toString());
        List<String>result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }

    @Test
    public void getPositionalMessagesExist02() throws ParseException {
        String[] datas = {"31-12-2020 17:00","31-12-2020 17:02"};
        List<String> expected = new ArrayList<>();
        expected.add(location3.toString());
        List<String>result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }

    @Test
    public void getPositionalMessagesExist03() throws ParseException {
        String[] datas = {"31-12-2020 16:00","31-12-2020 16:30"};
        List<String> expected = new ArrayList<>();
        expected.add(location2.toString());
        List<String>result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }

    @Test
    public void getPositionalMessagesExist04() throws ParseException {
        String[] datas = {"31-12-2020 12:00","31-12-2020 18:30"};
        List<String> expected = new ArrayList<>();
        expected.add(location2.toString());
        expected.add(location3.toString());
        List<String>result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }

    @Test
    public void verifyTreeSizeIsEmpty(){
        assertEquals(0, new BstShip<>().size());
    }

    @Test
    public void verifyTreeSizeEqualsOne(){
        Ship ship = new Ship("211331640",",SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,79,13,tree);
        Company company = new Company();
        company.getBstShip().insert(ship);
        assertEquals(1, company.getBstShip().size());
    }

    @Test
    public void verifyTreeRemove(){
        Ship ship = new Ship("211331647",",SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,79,13,tree);
        Company company = new Company();
        company.getBstShip().insert(ship);
        company.getBstShip().remove(ship);
        assertEquals(0, company.getBstShip().size());
    }

    @Test
    public void verifyTreeRemove2(){
        Ship ship = new Ship("211331649",",SEOUL EXPRESS","IMO2113432",1,280,"DHBN",70,294,32,79,13,tree);
        Company company = new Company();
        company.getBstShip().insert(ship);
        company.getBstShip().remove(ship);
        assertEquals(0, company.getBstShip().size());
    }
}