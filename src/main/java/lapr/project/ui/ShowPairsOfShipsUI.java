package lapr.project.ui;

import lapr.project.controller.ShowPairsOfShipsController;
import java.util.List;
import java.util.TreeMap;

/**
 * Represents an interface with the Traffic Manager to view the pairs of ships  with routes with close departure/arrival coordinates  and with different Travelled Distance
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShowPairsOfShipsUI implements Runnable{

    /**
     * Represents an instance of Show Pair of Ships Controller.
     */
    private final ShowPairsOfShipsController showPairsOfShipsCtrl;

    /**
     * Initializes the controller.
     */
    public ShowPairsOfShipsUI(){
        showPairsOfShipsCtrl=new ShowPairsOfShipsController();
    }

    @Override
    public void run() {
        System.out.printf("%nPairs of Ships with routes with close departure/arrival coordinates  and with different Travelled Distance%n");
        List<TreeMap<Double,String>> listPairsOfShips = showPairsOfShipsCtrl.getPairsOfShip();
        for (TreeMap<Double,String> list : listPairsOfShips){
            System.out.println(list);
            System.out.println();
        }
    }
}
