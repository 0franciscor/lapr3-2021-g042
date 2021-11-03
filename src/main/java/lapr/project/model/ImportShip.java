package lapr.project.model;

import lapr.project.controller.App;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * The ImportShip class, which allows the user to import ships and its locations from a .csv file
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class ImportShip {

    /**
     * The file to be imported
     */
    File file;

    /**
     * The Scanner which reads the file
     */
    Scanner readFile;

    /**
     * The class constructor
     */
    public ImportShip(){}

    /**
     * @param fileName The file name
     *
     * Allows the class to fetch the file desired by the user
     *
     * @return the success of the operation
     */
    public boolean getFile(String fileName) {
        file = new File(fileName);
        if(file.exists()) {
            try {
                readFile = new Scanner(file);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Manages the lines which are sent to getLineArray and createShip.
     *
     * @return The number of ships which were not imported
     */
    public int convertShips(){
        int shipsNotConverted = 0;
        readFile.next();
        while(readFile.hasNext()){
            String line = readFile.next();
            String[] shipArray = getLineArray(line);
            shipsNotConverted += createShip(shipArray);
        }
        readFile.close();
        return shipsNotConverted;
    }

    /**
     * @param shipLine Each line of the .csv file
     * @return the line splitted as an array
     */
    public String [] getLineArray(String shipLine){
        String[] dataArray = shipLine.split(",");
        return dataArray;
    }

    /**
     * @param shipArray containing all the line data
     *
     * Creates and adds ships to the BstShip
     *
     * @return 1 if the ship was not added or 0 if it was
     */
    public int createShip(String [] shipArray) {
        String MMSI = shipArray[0];

        Date messageTime = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            messageTime = dateFormatter.parse(shipArray[1]);
        }catch (Exception e) {
            return 1;
        }

        float latitude = Float.parseFloat(shipArray[2]);
        float longitude = Float.parseFloat(shipArray[3]);
        float SOG = Float.parseFloat(shipArray[4]);
        float COG = Float.parseFloat(shipArray[5]);
        float heading = Float.parseFloat(shipArray[6]);
        String name = shipArray[7];
        String shipID = shipArray[8];
        String callSign = shipArray[9];
        int vesselType = Integer.parseInt(shipArray[10]);
        float lenght = Float.parseFloat(shipArray[11]);
        float width = Float.parseFloat(shipArray[12]);
        float draft = Float.parseFloat(shipArray[13]);

        float cargo;
        if(shipArray[14].equals("NA"))
            cargo = 0;
        else
            cargo = Float.parseFloat(shipArray[14]);

        String transcieverClass = shipArray[15];


        ShipLocation shipLocation = new ShipLocation(messageTime, latitude, longitude, SOG, COG, heading, transcieverClass);
        BstShip shipBST = App.getApp().getCompany().getBstShip();
        Ship newShip = shipBST.getShipByMmsiCode(MMSI);

        if (newShip == null){
            newShip = new Ship(MMSI, name, shipID, 0, 0, callSign, vesselType, lenght, width, cargo, draft, shipLocation);
            shipBST.insert(newShip);
        } else
            newShip.getShipPosition().insert(shipLocation);

        return 0;
    }
}
