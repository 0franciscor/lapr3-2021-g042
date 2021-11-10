package lapr.project.controller;

import lapr.project.model.BriefSummary;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListSomeShipDataControllerTest {


    Company company;

    List<BriefSummary> bslist = new ArrayList<>();

    List<BriefSummary> BSlist = new ArrayList<>();

    List<BriefSummary> briefSummariesA = new ArrayList<>();

    List<BriefSummary> briefSummariesD = new ArrayList<>();



    public ListSomeShipDataControllerTest(){
        ImportShipController impShipCTR = new ImportShipController();
        impShipCTR.importFile("sships.csv");
        impShipCTR.importShips();
        ListSomeShipDataController controller = new ListSomeShipDataController();
        briefSummariesA = controller.organizeByAscendingOrder();
        briefSummariesD = controller.organizeByDescendingOrder();
    }

    /*

    @Test
    public void OrganizeByDescendingOrder(){ // descending travelled distance

        BriefSummary bs17 = new BriefSummary("305373000", 1, 138.59, 138.59); bslist.add(bs17);
        BriefSummary bs4 = new BriefSummary("228339600", 18, 85.22, 85.26); bslist.add(bs4);
        BriefSummary bs12 = new BriefSummary("257881000", 5, 78.95, 78.96); bslist.add(bs12);
        BriefSummary bs5 = new BriefSummary("229767000", 3, 75.79, 75.79); bslist.add(bs5);
        BriefSummary bs1 = new BriefSummary("210950000",24,58.87,58.88); bslist.add(bs1);
        BriefSummary bs2 = new BriefSummary("212180000",4,54.03,54.08); bslist.add(bs2);
        BriefSummary bs13 = new BriefSummary("258692000", 13, 33.25, 33.26); bslist.add(bs13);
        BriefSummary bs11 = new BriefSummary("256888000", 6, 13.52, 13.52); bslist.add(bs11);
        BriefSummary bs20 = new BriefSummary("636019825", 25, 12.16, 12.16); bslist.add(bs20);
        BriefSummary bs18 = new BriefSummary("305776000", 3, 6.54, 6.54); bslist.add(bs18);
        BriefSummary bs6 = new BriefSummary("229857000", 4, 2.47, 2.56); bslist.add(bs6);
        BriefSummary bs16 = new BriefSummary("305176000", 3, 1.53, 1.53); bslist.add(bs16);
        BriefSummary bs9 = new BriefSummary("249047000", 7, 0.02, 0.09); bslist.add(bs9);
        BriefSummary bs19 = new BriefSummary("309416000", 1, 0.07, 0.07); bslist.add(bs19);
        BriefSummary bs14 = new BriefSummary("303221000", 18, 0.00, 0.05); bslist.add(bs14);
        BriefSummary bs7 = new BriefSummary("229961000", 1, 0.02, 0.02); bslist.add(bs7);
        BriefSummary bs22 = new BriefSummary("636092932", 4, 0.01, 0.02); bslist.add(bs22);
        BriefSummary bs15 = new BriefSummary("303267000", 19, 0.00, 0.00); bslist.add(bs15);
        BriefSummary bs3 = new BriefSummary("212351000",0,0.0,0.0); bslist.add(bs3);
        BriefSummary bs8 = new BriefSummary("235092459", 0, 0.0, 0.0); bslist.add(bs8);
        BriefSummary bs10 = new BriefSummary("256304000", 0, 0.0, 0.0); bslist.add(bs10);
        BriefSummary bs21 = new BriefSummary("636091400", 0, 0.0, 0.0); bslist.add(bs21);



        assertEquals(bslist.toString(),briefSummariesD.toString());
    }

    @Test
    public void OrganizeByAscendingOrder(){ // total number of movements ascending

         BriefSummary bs3 = new BriefSummary("212351000",0,0.0,0.0); BSlist.add(bs3);
        BriefSummary bs8 = new BriefSummary("235092459", 0, 0.0, 0.0); BSlist.add(bs8);
        BriefSummary bs10 = new BriefSummary("256304000", 0, 0.0, 0.0); BSlist.add(bs10);
        BriefSummary bs21 = new BriefSummary("636091400", 0, 0.0, 0.0); BSlist.add(bs21);
        BriefSummary bs7 = new BriefSummary("229961000", 1, 0.02, 0.02); BSlist.add(bs7);
        BriefSummary bs17 = new BriefSummary("305373000", 1, 138.59, 138.59); BSlist.add(bs17);
        BriefSummary bs19 = new BriefSummary("309416000", 1, 0.07, 0.07); BSlist.add(bs19);
        BriefSummary bs5 = new BriefSummary("229767000", 3, 75.79, 75.79); BSlist.add(bs5);
        BriefSummary bs16 = new BriefSummary("305176000", 3, 1.53, 1.53); BSlist.add(bs16);
        BriefSummary bs18 = new BriefSummary("305776000", 3, 6.54, 6.54); BSlist.add(bs18);
        BriefSummary bs2 = new BriefSummary("212180000",4,54.03,54.08); BSlist.add(bs2);
        BriefSummary bs6 = new BriefSummary("229857000", 4, 2.47, 2.56); BSlist.add(bs6);
        BriefSummary bs22 = new BriefSummary("636092932", 4, 0.01, 0.02); BSlist.add(bs22);
        BriefSummary bs12 = new BriefSummary("257881000", 5, 78.95, 78.96); BSlist.add(bs12);
        BriefSummary bs11 = new BriefSummary("256888000", 6, 13.52, 13.52); BSlist.add(bs11);
        BriefSummary bs9 = new BriefSummary("249047000", 7, 0.02, 0.09); BSlist.add(bs9);
        BriefSummary bs13 = new BriefSummary("258692000", 13, 33.25, 33.26); BSlist.add(bs13);
        BriefSummary bs4 = new BriefSummary("228339600", 18, 85.22, 85.26); BSlist.add(bs4);
        BriefSummary bs14 = new BriefSummary("303221000", 18, 0.00, 0.05); BSlist.add(bs14);
        BriefSummary bs15 = new BriefSummary("303267000", 19, 0.00, 0.00); BSlist.add(bs15);
        BriefSummary bs1 = new BriefSummary("210950000",24,58.87,58.88); BSlist.add(bs1);
        BriefSummary bs20 = new BriefSummary("636019825", 25, 12.16, 12.16); BSlist.add(bs20);

        assertEquals(BSlist.toString(),briefSummariesA.toString());

    }

     */

}