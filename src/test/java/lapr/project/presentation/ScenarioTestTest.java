package lapr.project.presentation;

import lapr.project.controller.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ScenarioTestTest {

    private ImportShipController importShipController;

    private ShowPositionalMessagesController showPositionalMessagesController;

    private ShowPairsOfShipsController showPairsOfShipsController;

    private SearchDetailsController searchDetailsController;

    private MovementsSummaryController movementsSummaryController;

    private ListSomeShipDataController listSomeShipDataController;

    private ShowTopShipsController showTopShipsController;

    public ScenarioTestTest(){
        importShipController=new ImportShipController();
        showPositionalMessagesController=new ShowPositionalMessagesController();
        showPairsOfShipsController=new ShowPairsOfShipsController();
        searchDetailsController = new SearchDetailsController();
        movementsSummaryController = new MovementsSummaryController();
        listSomeShipDataController = new ListSomeShipDataController();
        showPairsOfShipsController = new ShowPairsOfShipsController();
        showTopShipsController = new ShowTopShipsController();
    }

    @Test
    public void apresentacao() throws ParseException, IOException {
        importShipController.importFile("sships.csv");
        importShipController.importShips();
        importShipController.importFile("bships.csv");
        importShipController.importShips();

        searchDetailsController.shipExistByIMO("IMO9395044");
        searchDetailsController.getShipDetails();
        searchDetailsController.writeDataSearchedByIMO();
        searchDetailsController.shipExistByCallSign("C4SQ2");
        searchDetailsController.getShipDetails();
        searchDetailsController.writeDataSearchedByCallsign();
        String[] auxDatas = {"25-12-2020 17:00","05-03-2021 17:30","31-12-2020 23:00"};
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        if(showPositionalMessagesController.shipExist("210950000")){
            showPositionalMessagesController.showPositionalMessages(dateFormatter.parse(auxDatas[0]),dateFormatter.parse(auxDatas[1]));
        }
        if(showPositionalMessagesController.shipExist("303221000")){
            showPositionalMessagesController.showPositionalMessages(dateFormatter.parse(auxDatas[2]));
        }
        movementsSummaryController.createSummaryDto(movementsSummaryController.createSummaryForShip(movementsSummaryController.getShipByMmsiCode("210950000")));
        listSomeShipDataController.organizeByDescendingOrder();
        showTopShipsController.getTopNShips(5,dateFormatter.parse(auxDatas[0]),dateFormatter.parse(auxDatas[1]));
        showPairsOfShipsController.getPairsOfShip();
    }


}