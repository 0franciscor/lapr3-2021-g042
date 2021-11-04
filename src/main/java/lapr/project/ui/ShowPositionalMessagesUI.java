package lapr.project.ui;

import lapr.project.controller.ShowPositionalMessagesController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an interface with the Traffic Manager to view the positional messages temporarily organized and associated with each of the ships
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShowPositionalMessagesUI implements Runnable{

    /**
     * Represents a instance of Show Positional Messages Controller.
     */
    private ShowPositionalMessagesController showPositionalMessagesctrl;

    /**
     * Initializes the controller.
     */
    public ShowPositionalMessagesUI(){
        showPositionalMessagesctrl = new ShowPositionalMessagesController();
    }

    /**
     *
     */
    @Override
    public void run() {

        System.out.printf("%nViewing a Ship's Positional Messages in a given period%n");

        String mmsiCode = readLineFromConsole("Enter the MMSI code of the vessel you wish to obtain information from.");
        if (showPositionalMessagesctrl.shipExist(mmsiCode)){
            Date initialDate = readDateFromConsole("Enter the initial date of the information you want to obtain");
            Date finalDate = readDateFromConsole("Enter the final date of the information you want to obtain");
            showPositionalMessagesctrl.showPositionalMessages(initialDate,finalDate);
        } else {
            System.out.printf("%nThere is no ship in the system with this MMSI code%n");
        }

    }

    static public String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public Date readDateFromConsole(String prompt) {
        do {
            try {
                String strDate = readLineFromConsole(prompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException e){
                e.printStackTrace();
                return null;
            }
        } while (true);
    }

}
