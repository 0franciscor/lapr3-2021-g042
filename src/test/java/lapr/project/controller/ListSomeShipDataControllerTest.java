package lapr.project.controller;

import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ListSomeShipDataControllerTest {


    Company company;

    List<BriefSummary> bslist = new ArrayList<>();

    List<BriefSummary> BSlist = new ArrayList<>();

    List<BriefSummary> briefSummariesA = new ArrayList<>();

    List<BriefSummary> briefSummariesD = new ArrayList<>();


    @BeforeEach
    public void SetUp(){
        ImportShipController impShipCTR = new ImportShipController();
        impShipCTR.importFile("sships.csv");
        impShipCTR.importShips();
        ListSomeShipDataController controller = new ListSomeShipDataController();
        briefSummariesA = controller.organizeByAscendingOrder();
        briefSummariesD = controller.organizeByDescendingOrder();
        System.out.println(briefSummariesA);
    }


    /*@Test
    public void OrganizeByDescendingOrder(){ // descending travelled distance

        BriefSummary bs17 = new BriefSummary("305373000", 1, 138.59, 138.59); bslist.add(bs17);
        BriefSummary bs9 = new BriefSummary("249047000", 7, 17.86, 92.76); bslist.add(bs9);
        BriefSummary bs4 = new BriefSummary("228339600", 18, 85.22, 85.26); bslist.add(bs4);
        BriefSummary bs12 = new BriefSummary("257881000", 5, 78.95, 78.96); bslist.add(bs12);
        BriefSummary bs5 = new BriefSummary("229767000", 3, 75.79, 75.79); bslist.add(bs5);
        BriefSummary bs19 = new BriefSummary("309416000", 1, 71.55, 71.55); bslist.add(bs19);
        BriefSummary bs1 = new BriefSummary("210950000",24,58.87,58.88); bslist.add(bs1);
        BriefSummary bs14 = new BriefSummary("303221000", 18, 1.71, 54.26); bslist.add(bs14);
        BriefSummary bs2 = new BriefSummary("212180000",4,54.03,54.07); bslist.add(bs2);
        BriefSummary bs13 = new BriefSummary("258692000", 13, 33.25, 33.26); bslist.add(bs13);
        BriefSummary bs7 = new BriefSummary("229961000", 1, 23.17, 23.17); bslist.add(bs7);
        BriefSummary bs22 = new BriefSummary("636092932", 4, 7.44, 19.99); bslist.add(bs22);
        BriefSummary bs11 = new BriefSummary("256888000", 6, 13.52, 13.52); bslist.add(bs11);
        BriefSummary bs20 = new BriefSummary("636019825", 25, 12.16, 12.16); bslist.add(bs20);
        BriefSummary bs18 = new BriefSummary("305776000", 3, 6.54, 6.54); bslist.add(bs18);
        BriefSummary bs6 = new BriefSummary("229857000", 4, 2.47, 2.56); bslist.add(bs6);
        BriefSummary bs15 = new BriefSummary("303267000", 19, 1.24, 2.35); bslist.add(bs15);
        BriefSummary bs16 = new BriefSummary("305176000", 3, 1.53, 1.53); bslist.add(bs16);
        BriefSummary bs3 = new BriefSummary("212351000",0,0.0,0.0); bslist.add(bs3);
        BriefSummary bs8 = new BriefSummary("235092459", 0, 0.0, 0.0); bslist.add(bs8);
        BriefSummary bs10 = new BriefSummary("256304000", 0, 0.0, 0.0); bslist.add(bs10);
        BriefSummary bs21 = new BriefSummary("636091400", 0, 0.0, 0.0); bslist.add(bs21);


        Assert.assertEquals(bslist.toString(),briefSummariesD.toString());
    }

    @Test
    public void OrganizeByAscendingOrder(){ // total number of movements ascending

        BriefSummary bs3 = new BriefSummary("212351000",0,0.0,0.0); BSlist.add(bs3);
        BriefSummary bs8 = new BriefSummary("235092459", 0, 0.0, 0.0); BSlist.add(bs8);
        BriefSummary bs7 = new BriefSummary("229961000", 1, 23.17, 23.17); BSlist.add(bs7);
        BriefSummary bs17 = new BriefSummary("305373000", 1, 138594.84, 138594.84); BSlist.add(bs17);
        BriefSummary bs19 = new BriefSummary("309416000", 1, 71.55, 71.55); BSlist.add(bs19);
        BriefSummary bs5 = new BriefSummary("229767000", 3, 75787.37, 75787.44); BSlist.add(bs5);
        BriefSummary bs16 = new BriefSummary("305176000", 3, 1526.62, 1526.64); BSlist.add(bs16);
        BriefSummary bs18 = new BriefSummary("305776000", 3, 6542.34, 6542.63); BSlist.add(bs18);
        BriefSummary bs2 = new BriefSummary("212180000",4,54033.18,54077.11); BSlist.add(bs2);
        BriefSummary bs6 = new BriefSummary("229857000", 4, 2468.98, 2555.31); BSlist.add(bs6);
        BriefSummary bs22 = new BriefSummary("636092932", 4, 7.44, 19.99); BSlist.add(bs22);
        BriefSummary bs12 = new BriefSummary("257881000", 5, 78953.21, 78959.10); BSlist.add(bs12);
        BriefSummary bs11 = new BriefSummary("256888000", 6, 13522.85, 13524.96); BSlist.add(bs11);
        BriefSummary bs9 = new BriefSummary("249047000", 7, 17.86, 92.76); BSlist.add(bs9);
        BriefSummary bs13 = new BriefSummary("258692000", 13, 33252.32, 33255.79); BSlist.add(bs13);
        BriefSummary bs4 = new BriefSummary("228339600", 18, 85222.07, 85261.64); BSlist.add(bs4);
        BriefSummary bs14 = new BriefSummary("303221000", 18, 1.71, 54.26); BSlist.add(bs14);
        BriefSummary bs15 = new BriefSummary("303267000", 19, 1.24, 2.35); BSlist.add(bs15);
        BriefSummary bs1 = new BriefSummary("210950000",24,58868.74,58875.17); BSlist.add(bs1);
        BriefSummary bs20 = new BriefSummary("636019825", 25, 12156.40, 12157.97); BSlist.add(bs20);

        Assert.assertEquals(BSlist.toString(),briefSummariesA.toString());

    }*/

}