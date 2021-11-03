package lapr.project.model;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShipLocationBSTTest {


    List<ShipLocation> arr = new ArrayList<>();

    String[] auxDatas = {"31-12-2020 01:25","31-12-2020 16:15","31-12-2020 17:02"};

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    ShipLocationBST<ShipLocation> tree;

    public ShipLocationBSTTest() throws ParseException {
        arr.add(new ShipLocation(dateFormatter.parse(auxDatas[0]),36,-122,19,145,147,"B"));
        arr.add(new ShipLocation(dateFormatter.parse(auxDatas[1]),36,-122,19,145,147,"B"));
        arr.add(new ShipLocation(dateFormatter.parse(auxDatas[2]),36,-122,19,145,147,"B"));
    }

    @Before
    public void setUp(){
        tree = new ShipLocationBST();
        for(ShipLocation i :arr)
            tree.insert(i);
        Ship ship = new Ship("211331640",",SEOUL EXPRESS","2113432",1,280,"DHBN",70,294,32,79,13,tree);
    }

    @Test
    public void getPositionalMessagesNotExist() throws ParseException {
        String[] datas = {"30-12-2020 01:25","30-12-2020 17:02"};
        List<String> result = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        result=tree.getPositionalMessages(dateFormatter.parse(datas[0]),dateFormatter.parse(datas[1]));
        assertEquals(expected,result);
    }
}