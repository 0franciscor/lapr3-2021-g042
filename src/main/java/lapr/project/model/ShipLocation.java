package lapr.project.model;

import java.util.Date;

/**
 *
 * @author 1201239 Francisco Redol
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShipLocation implements Comparable<ShipLocation>{

    private Date messageTime;

    private String latitude;

    private String longitude;

    private float SOG;

    private float COG;

    private String heading;

    private String position;

    private String transceiverClass;


    public ShipLocation(){}

    public ShipLocation(Date messageTime, String latitude, String longitude, float SOG, float COG, String heading, String position, String transceiverClass){
        this.messageTime = messageTime;
        setLatitude(latitude);
        setLongitude(longitude);
        setSOG(SOG);
        setCOG(COG);
        setHeading(heading);
        this.position = position;
        this.transceiverClass = transceiverClass;

    }

    public ShipLocation(Date messageTime, String latitude, String longitude, float SOG, float COG, String heading, String transceiverClass){
        this.messageTime = messageTime;
        setLatitude(latitude);
        setLongitude(longitude);
        setSOG(SOG);
        setCOG(COG);
        setHeading(heading);
        this.position = "not defined";
        this.transceiverClass = transceiverClass;

    }

    public void setLatitude(String latitude){
        if(latitude == null || latitude.isEmpty())
            throw new IllegalArgumentException("Invalid Latitude.");

        if(latitude.equals("91"))
            this.latitude = "not available";
        else if(Float.parseFloat(latitude) < -90 || Float.parseFloat(latitude)  > 90)
            throw new IllegalArgumentException("Invalid Latitude.");
        else
            this.latitude = latitude;
    }

    public void setLongitude(String longitude){
        if(longitude == null || longitude.isEmpty())
            throw new IllegalArgumentException("Invalid Longitude.");

        if(longitude.equals("181"))
            this.longitude = "not available";
        else if(Float.parseFloat(longitude) < -180 || Float.parseFloat(longitude)  > 180)
            throw new IllegalArgumentException("Invalid Longitude.");
        else
            this.longitude = longitude;
    }

    public void setSOG(float SOG){
        if(SOG < 0)
            throw new IllegalArgumentException("Invalid SOG.");
        else
            this.SOG = SOG;
    }

    public void setCOG(float COG){
        if(COG < 0)
            this.COG = 360 + COG;
        else if (COG > 360)
            this.COG = 360 - COG;
        else
            this.COG = COG;
    }

    public void setHeading(String heading){
        if(heading == null || heading.isEmpty())
            throw new IllegalArgumentException("Invalid Heading.");

        if(heading.equals("511"))
            this.heading = "not available";
        else if(Integer.parseInt(heading) < 0 || Integer.parseInt(heading) > 359)
            throw new IllegalArgumentException("Invalid Heading.");
        else
            this.heading = heading;
    }

    public Date getMessageTime() {return messageTime;}

    public String getLatitude(){
        return latitude;
    }

    public String getLongitude(){
        return longitude;
    }

    public float getSOG (){
        return SOG;
    }

    public float getCOG (){
        return COG;
    }

    public String getHeading (){
        return heading;
    }

    public String getPosition(){
        return position;
    }

    public String getTransceiverClass(){
        return transceiverClass;
    }

    @Override
    public int compareTo(ShipLocation o) {
        return this.messageTime.compareTo(o.getMessageTime());
    }

    /**
     * Textual description of the ship's location
     * @return a string representation of the ship location
     */
    @Override
    public String toString(){
        return String.format("\nDate: %s\nLatitude: %s\nLongitude: %s\n\nSOG: %f\nCOG: %f\nHeading: %s\n",messageTime,latitude,longitude,SOG,COG,heading);
    }
}
