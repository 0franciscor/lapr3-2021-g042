package lapr.project.controller;

import lapr.project.mapper.ShipDetailsMapper;
import lapr.project.model.BstShip;
import lapr.project.model.Company;
import lapr.project.model.Ship;

import java.util.Objects;

/**
 * Class responsible for making the connection between the UI and the system when searching for ship details
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class SearchDetailsController {

    /**
     * Represents an instance of Company
     */
    private Company company;

    /**
     * Represents an instance of BstShip
     */
    private BstShip bstShip;

    /**
     * Represents an instance of ship
     */
    private Ship ship;

    /**
     * Initialize the controller
     */
    public SearchDetailsController(){
        this.company = App.getInstance().getCompany();
        this.bstShip = company.getBstShip();
        shipDetailsMapper = new ShipDetailsMapper();
    }

    /**
     * Initialize the controller
     */
    public SearchDetailsController(Company company){
        this.company = company;
        this.bstShip = company.getBstShip();
        shipDetailsMapper = new ShipDetailsMapper();
    }
    /**
     * Represents an instance of the ship mapper.
     */
    private ShipDetailsMapper shipDetailsMapper;



    /**
     * This method allows the user to search a certain ship on the BST through its MMSI code.
     * @param mmsiCode
     * @return
     */
    public boolean shipExistByMMSI(String mmsiCode){
        return (this.ship = bstShip.getShipByMmsiCode(mmsiCode)) != null;
    }

    /**
     * This method allows the user to search a certain ship using the IMO Code.
     * @param imoCode
     * @return The ship with de respective IMO Code
     */
    public Ship shipExistByIMO(String imoCode){
        Iterable<Ship> ships = bstShip.inOrder();
        for (Ship s : ships){
            if (Objects.equals(s.getShipID(), imoCode)){
                this.ship = s;
                return  s;
            }
        } return null;
    }

    /**
     * This method allows the user to search a certain ship using the Call Sign
     * @param callsign
     * @return The ship with the respective Call Sign
     */
    public Ship shipExistByCallSign(String callsign){
        Iterable<Ship> ships = bstShip.inOrder();
        for (Ship s : ships){
            if (s.getCallSign().equals(callsign)){
                this.ship = s;
                return  s;
            }
        } return null;
    }
    /**
     *  This method allows the user to search a certain ship on the BST through its MMSI code (unique code).
     * @return The details of the ship
     */
    public String getShipDetails(){
        return shipDetailsMapper.toDto(this.ship).toString();
    }


}
