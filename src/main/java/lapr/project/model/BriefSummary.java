package lapr.project.model;

public class BriefSummary implements Comparable{

    /**
     * The ship's MMSI
     */
    private String mmsiCode;

    /**
     * Represent the total number of movements
     */
    private int totalNumberOfMovements;

    /**
     * Represents the delta distance
     */
    private double deltaDistance;

    /**
     * Represents the travelled distance
     */
    private double travelledDistance;

    /**
     * Brief's Summary constructor
     * @param mmsiCode
     * @param totalNumberOfMovements
     * @param deltaDistance
     * @param travelledDistance
     */
    public BriefSummary(String mmsiCode, int totalNumberOfMovements, double deltaDistance, double travelledDistance) {
        this.mmsiCode = mmsiCode;
        this.totalNumberOfMovements = totalNumberOfMovements;
        this.deltaDistance = deltaDistance;
        this.travelledDistance = travelledDistance;
    }

    /**
     * @return ship's MMSI
     */
    public String getMmsiCode() {
        return mmsiCode;
    }

    /**
     * @return ship's total of movements
     */
    public int getTotalNumberOfMovements() {
        return totalNumberOfMovements;
    }

    /**
     * @return ship's delta distance
     */
    public double getDeltaDistance() {
        return deltaDistance;
    }

    /**
     * @return ship's travelled distance
     */
    public double getTravelledDistance() {
        return travelledDistance;
    }


    /**
     *
     */
    @Override
    public int compareTo(Object o) {
        return 1;
    }

    /**
     * @return information about a certain ship
     */
    @Override
    public String toString() {
        return "BriefSummary{" +
                "mmsiCode='" + mmsiCode + '\'' +
                ", totalNumberOfMovements=" + totalNumberOfMovements +
                ", deltaDistance=" + deltaDistance +
                ", travelledDistance=" + travelledDistance +
                '}';
    }

}
