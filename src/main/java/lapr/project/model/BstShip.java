package lapr.project.model;


/**
 * Class that represents a BstShip
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class BstShip {



    /**
     * Constructs an empty binary search tree
     */
    public BstShip() {

    }

    /**
     *
     * @param mmsiCode
     * @return
     */
    public Ship getShipByMmsiCode(String mmsiCode){
        return new Ship();
    }


    /**
     *
     * @param imoCode
     * @return
     */
    public Ship getShipByIMO(String imoCode){
        return new Ship();
    }

    /**
     *
     * @param callSign
     * @return
     */
    public Ship getShipByCallSign(String callSign){
        return new Ship();
    }
}
