package lapr.project.controller;

import lapr.project.model.BriefSummary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class ListSomeShipDataControllerTest {

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
    }

    @Test
    public void OrganizeByDescendingOrder(){ // descending travelled distance

        boolean flag = true;
        BriefSummary anterior = briefSummariesD.get(0);
        for( int i=1; i<briefSummariesD.size(); i++) {
            BriefSummary atual = briefSummariesD.get(i);
            if (atual.getTravelledDistance()>anterior.getTravelledDistance()) {
                flag = false;
                break;
            }
            atual = anterior;
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void OrganizeByAscendingOrder(){ // total number of movements ascending

        boolean flag = true;
        BriefSummary anterior = briefSummariesA.get(0);
        for( int i=1; i<briefSummariesA.size(); i++) {
            BriefSummary atual = briefSummariesA.get(i);
            if (atual.getTotalNumberOfMovements()<anterior.getTotalNumberOfMovements()) {
                flag = false;
                break;
            }
            atual = anterior;
        }
        Assert.assertTrue(flag);
    }


}