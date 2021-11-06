package lapr.project.model;

public class BriefSummary implements Comparable{
    /**
     *
     */
    private String mmsiCode;

    /**
     *
     */
    private int totalNumberOfMovements;

    /**
     *
     */
    private double deltaDistance;

    /**
     *
     */
    private double travelledDistance;

    /**
     *
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
     *
     * @return
     */
    public String getMmsiCode() {
        return mmsiCode;
    }

    /**
     *
     * @return
     */
    public int getTotalNumberOfMovements() {
        return totalNumberOfMovements;
    }

    /**
     *
     * @return
     */
    public double getDeltaDistance() {
        return deltaDistance;
    }

    /**
     *
     * @return
     */
    public double getTravelledDistance() {
        return travelledDistance;
    }


    @Override
    public int compareTo(Object o) {
        return 1;
    }

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
