package lapr.project.controller;

import lapr.project.model.Company;

public class SendToDatabase {

    SendToDatabase sendToDatabase;

    public SendToDatabase(){
        sendToDatabase = new SendToDatabase();
    }

    public void sendShipsAndLocations(){
        sendToDatabase.sendShipsAndLocations();
    }

    public void sendPorts(){
        sendToDatabase.sendPorts();
    }
}
