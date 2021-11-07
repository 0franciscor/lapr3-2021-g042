package lapr.project.mapper.dto;

import lapr.project.model.Summary;

import java.util.Date;

/**
 * Represents a data transfer object of Summary
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */

public class SummaryDto {

    /**
     * The MMSI code of a ship
     */
    private String mmsiCode;

    /**
     * The ships name
     */
    private String name;

    /**
     * The date and time of starting of journey
     */
    private Date startBaseDate;

    /**
     * The date and time of end of journey
     */
    private Date endBaseDate;

    /**
     * The total time spend in the journey
     */
    private String totalMovementTime;

    /**
     * The total movements made in the journey
     */
    private int totalMovements;

    /**
     * The maximum speed over ground of a ship
     */
    private double maximumSog;

    /**
     * The mean speed over ground of a ship
     */
    private double meanSog;

    /**
     * The maximum course over ground of a ship
     */
    private double maximumCog;

    /**
     * The mean course over ground of a ship
     */
    private double meanCog;

    /**
     * The departure latitude of the journey
     */
    private String departureLatitude;

    /**
     * The departure longitude of the journey
     */
    private String departureLongitude;

    /**
     * The arrival latitude of the journey
     */
    private String arrivalLatitude;

    /**
     * The arrival longitude of the journey
     */
    private String arrivalLongitude;

    /**
     * The total distance travelled
     */
    private double travelledDistance;

    /**
     * The delta distance of the journey
     */
    private double deltaDistance;

    /**
     * Creates a new instance of SummaryDto
     * @param mmsiCode MMSI code associated with a ship
     * @param name ships name
     * @param startBaseDate the start base of journey
     * @param endBaseDate the end base of journey
     * @param totalMovementTime the time spend in journey
     * @param totalMovements the total movements made in journey
     * @param maximumSog the maximum speed over ground of a ship
     * @param meanSog the mean speed over ground of a ship
     * @param maximumCog the maximum course ver ground of a ship
     * @param meanCog the mean speed over ground of a ship
     * @param departureLatitude the latitude of the departure location
     * @param departureLongitude the longitude of the departure location
     * @param arrivalLatitude the latitude of the arrival location
     * @param arrivalLongitude the longitude of the arrival location
     * @param travelledDistance the travelled distance made in a journey
     * @param deltaDistance the delta distance made in a journey
     */
    public SummaryDto(String mmsiCode, String name, Date startBaseDate, Date endBaseDate, String totalMovementTime, int totalMovements, double maximumSog, double meanSog, double maximumCog, double meanCog, String departureLatitude, String departureLongitude, String arrivalLatitude, String arrivalLongitude, double travelledDistance, double deltaDistance) {
        this.mmsiCode = mmsiCode;
        this.name = name;
        this.startBaseDate = startBaseDate;
        this.endBaseDate = endBaseDate;
        this.totalMovementTime = totalMovementTime;
        this.totalMovements = totalMovements;
        this.maximumSog = maximumSog;
        this.meanSog = meanSog;
        this.maximumCog = maximumCog;
        this.meanCog = meanCog;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.arrivalLatitude = arrivalLatitude;
        this.arrivalLongitude = arrivalLongitude;
        this.travelledDistance = travelledDistance;
        this.deltaDistance = deltaDistance;
    }

    /**
     * Creates a new instance of SummaryDto receiving a Summary as parameter
     * @param summary the summary
     */
    public SummaryDto(lapr.project.model.Summary summary){
        this.mmsiCode = summary.getMmsiCode();
        this.name = summary.getName();
        this.startBaseDate = summary.getStartBaseDate();
        this.endBaseDate = summary.getEndBaseDate();
        this.totalMovementTime = summary.getTotalMovementTime();
        this.totalMovements = summary.getTotalMovements();
        this.maximumSog = summary.getMaximumSog();
        this.meanSog = summary.getMeanSog();
        this.maximumCog = summary.getMaximumCog();
        this.meanCog = summary.getMeanCog();
        this.departureLatitude = summary.getDepartureLatitude();
        this.departureLongitude = summary.getDepartureLongitude();
        this.arrivalLatitude = summary.getArrivalLatitude();
        this.arrivalLongitude = summary.getArrivalLongitude();
        this.travelledDistance = summary.getTravelledDistance();
        this.deltaDistance = summary.getDeltaDistance();
    }

    /**
     * Get the MMSI code associated with a ship
     * @return the MMSI code
     */
    public String getMmsiCode() {
        return mmsiCode;
    }

    /**
     * Get the ships name
     * @return the ship name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the date and time the ship leaves the port where the voyage began
     * @return the date of start of a journey
     */
    public Date getStartBaseDate() {
        return startBaseDate;
    }

    /**
     * Get the date and time the ship arrives at its port of destination
     * @return the date of arrival in port
     */
    public Date getEndBaseDate() {
        return endBaseDate;
    }

    /**
     * Get the total time of movements made by a ship in the travel
     * @return the total time of movements
     */
    public String getTotalMovementTime() {
        return totalMovementTime;
    }

    /**
     * Get the total number of movements made by a ship in the travel
     * @return the total number of movements
     */
    public int getTotalMovements() {
        return totalMovements;
    }

    /**
     * Get the maximum speed over ground of a ship
     * @return the maximum speed over ground
     */
    public double getMaximumSog() {
        return maximumSog;
    }

    /**
     * Get the mean speed over ground of a ship
     * @return the mean speed over ground
     */
    public double getMeanSog() {
        return meanSog;
    }

    /**
     * Get the maximum course over ground of a ship
     * @return the maximum course over ground
     */
    public double getMaximumCog() {
        return maximumCog;
    }

    /**
     * Get the mean course over ground of a ship
     * @return the mean course over ground
     */
    public double getMeanCog() {
        return meanCog;
    }

    /**
     * Get the latitude of the departure of a ship
     * @return the departure latitude
     */
    public String getDepartureLatitude() {
        return departureLatitude;
    }

    /**
     * Get the longitude of the departure of a ship
     * @return the departure longitude
     */
    public String getDepartureLongitude() {
        return departureLongitude;
    }

    /**
     * Get the latitude of the arrival of a ship
     * @return the arrival latitude
     */
    public String getArrivalLatitude() {
        return arrivalLatitude;
    }

    /**
     * Get the longitude of the arrival of a ship
     * @return the arrival longitude
     */
    public String getArrivalLongitude() {
        return arrivalLongitude;
    }

    /**
     * Get the travelled distance of a ship
     * @return the traveled distance
     */
    public double getTravelledDistance() {
        return travelledDistance;
    }

    /**
     * Get the delta distance traveled by a ship
     * @return the delta distance
     */
    public double getDeltaDistance() {
        return deltaDistance;
    }

    /**
     * Textual description of the contents in a summary
     * @return Information that characterizes a summary
     */
    @Override
    public String toString() {
        return String.format("----------* Summary *----------\n " +
                "MMSI Code: %s \n" +
                "Ship name: %s \n" +
                "Start Base Date: %s \n" +
                "End Base Date: %s \n" +
                "Total Movements Time: %s \n" +
                "Total Movements: %d \n" +
                "Maximum Speed Over Ground: %.2f \n" +
                "Mean Speed Over Ground: %.2f \n" +
                "Maximum Course Over Ground: %.2f \n" +
                "Mean Course Over Ground: %.2f \n" +
                "Departure Latitude: %s \n" +
                "Departure Longitude: %s \n" +
                "Arrival Latitude: %s \n" +
                "Arrival Longitude: %s \n" +
                "Travelled Distance: %.2f \n" +
                "Delta Distance: %.2f \n"
                , mmsiCode, name, startBaseDate, endBaseDate, totalMovementTime, totalMovements, maximumSog, meanSog, maximumCog, meanCog, departureLatitude, departureLongitude, arrivalLatitude, arrivalLongitude, travelledDistance, deltaDistance

        );


    }
}
