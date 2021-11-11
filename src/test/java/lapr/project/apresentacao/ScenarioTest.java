package lapr.project.apresentacao;

import lapr.project.controller.ImportShipController;
import lapr.project.controller.ShowPairsOfShipsController;
import lapr.project.controller.ShowPositionalMessagesController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ScenarioTest {

    private ImportShipController importShipController;

    private ShowPositionalMessagesController showPositionalMessagesController;

    private ShowPairsOfShipsController showPairsOfShipsController;

    public ScenarioTest(){
        importShipController=new ImportShipController();
        showPositionalMessagesController=new ShowPositionalMessagesController();
        showPairsOfShipsController=new ShowPairsOfShipsController();
    }

    @Test
    public void apresentacao() throws ParseException, IOException {

        /*
        importShipController.importFile("sships.csv");
        importShipController.importShips();
        String[] auxDatas = {"31-12-2020 17:00","31-12-2020 17:30","31-12-2020 23:00"};
        if(showPositionalMessagesController.shipExist("210950000")){
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            showPositionalMessagesController.showPositionalMessages(dateFormatter.parse(auxDatas[0]),dateFormatter.parse(auxDatas[1]));
        }
        if(showPositionalMessagesController.shipExist("303221000")){
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            showPositionalMessagesController.showPositionalMessages(dateFormatter.parse(auxDatas[2]));
        }
        importShipController.importFile("bships.csv");
        importShipController.importShips();
        showPairsOfShipsController.getPairsOfShip();

         */
    }


}
