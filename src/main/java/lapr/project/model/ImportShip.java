package lapr.project.model;

import lapr.project.controller.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ImportShip {

    File file;
    Scanner readFile;


    public ImportShip(){}

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

    public String [] getLineArray(String shipLine){
        String[] dataArray = shipLine.split(",");
        return dataArray;
    }

    public int createShip(String [] shipArray) {
        String MMSI = shipArray[0];

        Date messageTime = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            messageTime = dateFormatter.parse(shipArray[1]);
        }catch (Exception e) {
            System.out.println("Erro");
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

        BstShip shipBST = new App().getCompany().getBstShip();
        //shipBST.ins
        return 0;
    }
}
