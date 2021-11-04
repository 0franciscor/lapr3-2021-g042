package lapr.project.controller;

import lapr.project.mapper.ShipMapper;
import lapr.project.mapper.dto.ShipDto;
import lapr.project.model.BstShip;
import lapr.project.model.Company;
import lapr.project.model.Ship;

/**
 * Class responsible for making the connection between the UI and the system when searching for ship details
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class SearchDetailsController {

    /**
     * Represents a instance of Company
     */
    private Company company;

    /**
     * Represents a instance of BstShip
     */
    private BstShip bstShip;

    /**
     * Represents a instance of ship
     */
    private Ship ship;

    /**
     * Initialize the controller
     */
    public SearchDetailsController(){
        //this.company= new Company();
        this.bstShip=company.getBstShip();
        shipMapper = new ShipMapper();
    }

    /**
     * Represents an instance of the ship mapper
     */
    private ShipMapper shipMapper;



    /**
     *
     * @param mmsiCode
     * @return
     */
    public boolean shipExistByMMSI(String mmsiCode){
        return (this.ship = bstShip.getShipByMmsiCode(mmsiCode)) != null;
    }

    /**
     *
     * @param imoCode
     * @return
     */
    /*public boolean shipExistByIMO(String imoCode){
        return (this.ship = bstShip.getShipByIMO(imoCode)) != null;
    }*/

    /**
     *
     * @param callsign
     * @return
     */
    /*public boolean shipExistByCallSign(String callsign){
        return (this.ship = bstShip.getShipByCallSign(callsign)) != null;
    }*/

    /**
     *
     */
    public String getShipDetails(){
        Ship requestedShip = this.ship;
        return shipMapper.toDto(requestedShip).toString();
    }


}
