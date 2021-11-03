package lapr.project.model;

import java.util.Date;

/**
 *
 * @author 1201239 Francisco Redol
 */
public class ShipLocation implements Comparable<ShipLocation>{

    private Date messageTime;

    private float latitude;

    private float longitude;

    private float SOG;

    private float COG;

    private float heading;

    private String position;

    private String transcieverClass;

    public ShipLocation(){}

    public ShipLocation(Date messageTime, float latitude, float longitude, float SOG, float COG, float heading, String position, String transcieverClass){
        this.messageTime = messageTime;
        setLatitude(latitude);
        setLongitude(longitude);
        setSOG(SOG);
        setCOG(COG);
        setHeading(heading);
        this.position = position;
        this.transcieverClass = transcieverClass;

    }

    public ShipLocation(Date messageTime, float latitude, float longitude, float SOG, float COG, float heading, String transcieverClass){
        this.messageTime = messageTime;
        setLatitude(latitude);
        setLongitude(longitude);
        setSOG(SOG);
        setCOG(COG);
        setHeading(heading);
        this.position = "not defined";
        this.transcieverClass = transcieverClass;

    }

    public void setLatitude(float latitude){
        if(latitude<-90 || latitude > 90)
            throw new IllegalArgumentException("Invalid Latitude.");
        else
            this.latitude = latitude;
    }

    public void setLongitude(float longitude){
        if(longitude < -180 || longitude > 180)
            throw new IllegalArgumentException("Invalid Longitude.");
        else
            this.longitude = longitude;
    }

    public void setSOG(float SOG){
        if(SOG <= 0)
            throw new IllegalArgumentException("Invalid SOG.");
        else
            this.SOG = SOG;
    }

    public void setCOG(float COG){
        if(COG < 0 || COG > 359)
            throw new IllegalArgumentException("Invalid COG.");
        else
            this.COG = COG;
    }

    public void setHeading(float heading){
        if(heading < 0 || heading > 359)
            throw new IllegalArgumentException("Invalid heading.");
        else
            this.heading = heading;
    }

    public Date getMessageTime(){
        return messageTime;
    }

    public float getLatitude(){
        return latitude;
    }

    public float getLongitude(){
        return longitude;
    }

    public float getSOG (){
        return SOG;
    }

    public float getCOG (){
        return COG;
    }

    public float getHeading (){
        return heading;
    }

    public String getPosition(){
        return position;
    }

    public String getTranscieverClass(){
        return transcieverClass;
    }

    @Override
    public int compareTo(ShipLocation o) {
        return this.messageTime.compareTo(o.getMessageTime());
    }
}
