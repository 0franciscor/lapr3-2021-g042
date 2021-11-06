package lapr.project.ui;

import lapr.project.controller.ListSomeShipDataController;
import lapr.project.mapper.dto.SummaryDto;
import lapr.project.model.BriefSummary;
import lapr.project.model.Ship;
import lapr.project.model.Summary;
import lapr.project.utils.Utils;

import java.util.List;

public class ListSomeShipDataUi implements Runnable{

    private ListSomeShipDataController listSomeShipDataController;

    public ListSomeShipDataUi(){
        listSomeShipDataController = new ListSomeShipDataController();
    }

    @Override
    public void run() {
        System.out.printf("%nList of Summaries%n");

        List<BriefSummary> briefSummaries = listSomeShipDataController.getShipList();

        for (BriefSummary bs : briefSummaries){
            System.out.println(bs);
        }

    }
}
