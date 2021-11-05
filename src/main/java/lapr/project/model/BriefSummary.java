package lapr.project.model;

public class BriefSummary {
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
    private float deltaDistance;

    /**
     *
     */
    private float travelledDistance;

    /**
     *
     * @param mmsiCode
     * @param totalNumberOfMovements
     * @param deltaDistance
     * @param travelledDistance
     */
    public BriefSummary(String mmsiCode, int totalNumberOfMovements, float deltaDistance, float travelledDistance) {
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
    public float getDeltaDistance() {
        return deltaDistance;
    }

    /**
     *
     * @return
     */
    public float getTravelledDistance() {
        return travelledDistance;
    }
}
