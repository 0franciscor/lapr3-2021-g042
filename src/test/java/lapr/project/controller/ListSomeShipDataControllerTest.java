package lapr.project.controller;

import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

public class ListSomeShipDataControllerTest {

    //possiveis soluções:
    //importar o ficheiro dentro de cada teste
    //ou ir buscar os SHIPS à company


    Company company;

    ListSomeShipDataController controller = new ListSomeShipDataController();

    Iterable<Ship> inOrder;

    List<BriefSummary> bslist = new ArrayList<>();

    List<BriefSummary> briefSummaries;


    @Before
    public void setup(){
        company = App.getInstance().getCompany();
        inOrder = company.getBstShip().inOrder();
        briefSummaries = new ArrayList<>();
    }

    /*@Test
    public void getShipList() {
        BriefSummary bs1 = new BriefSummary("210950000",24,58868.74325416048,58875.170507493065); bslist.add(bs1);
        BriefSummary bs2 = new BriefSummary("212180000",4,54033.18113254823,54077.11948264001); bslist.add(bs2);
        BriefSummary bs3 = new BriefSummary("212351000",0,0.0,0.0); bslist.add(bs3);
        BriefSummary bs4 = new BriefSummary("228339600", 18, 85222.07283417792, 85261.64759566834); bslist.add(bs4);
        BriefSummary bs5 = new BriefSummary("229767000", 3, 75787.37724227374, 75787.44624090151); bslist.add(bs5);
        BriefSummary bs6 = new BriefSummary("229857000", 4, 2468.9804082428905, 2555.312135772355); bslist.add(bs6);
        BriefSummary bs7 = new BriefSummary("229961000", 1, 23.17870803303664, 23.17870803303664); bslist.add(bs7);
        BriefSummary bs8 = new BriefSummary("235092459", 0, 0.0, 0.0); bslist.add(bs8);
        BriefSummary bs9 = new BriefSummary("249047000", 7, 17.864281882363503, 92.76042205730083); bslist.add(bs9);
        BriefSummary bs10 = new BriefSummary("256304000", 0, 0.0, 0.0); bslist.add(bs10);
        BriefSummary bs11 = new BriefSummary("256888000", 6, 13522.858442965806, 13524.965951186734); bslist.add(bs11);
        BriefSummary bs12 = new BriefSummary("257881000", 5, 78953.21360604202, 78959.10076739654); bslist.add(bs12);
        BriefSummary bs13 = new BriefSummary("258692000", 13, 33252.32050320859, 33255.79588654652); bslist.add(bs13);
        BriefSummary bs14 = new BriefSummary("303221000", 18, 1.719039428125952, 54.26193581070395); bslist.add(bs14);
        BriefSummary bs15 = new BriefSummary("303267000", 19, 1.242560330733889, 2.351659239412898); bslist.add(bs15);
        BriefSummary bs16 = new BriefSummary("305176000", 3, 1526.6277003544387, 1526.6464735751154); bslist.add(bs16);
        BriefSummary bs17 = new BriefSummary("305373000", 1, 138594.84512822493, 138594.84512822493); bslist.add(bs17);
        BriefSummary bs18 = new BriefSummary("305776000", 3, 6542.342710451821, 6542.6309054520025); bslist.add(bs18);
        BriefSummary bs19 = new BriefSummary("309416000", 1, 71.55625896266619, 71.55625896266619); bslist.add(bs19);
        BriefSummary bs20 = new BriefSummary("636019825", 25, 12156.402556441526, 12157.977298036803); bslist.add(bs20);
        BriefSummary bs21 = new BriefSummary("636091400", 0, 0.0, 0.0); bslist.add(bs21);
        BriefSummary bs22 = new BriefSummary("636092932", 4, 7.444216255581629, 19.999704941446367); bslist.add(bs22);

        System.out.println(bslist);

        briefSummaries = controller.getShipList();
        System.out.println(briefSummaries);


        boolean result = bslist.equals(controller.getShipList());
        assertTrue(result);
    }*/
}