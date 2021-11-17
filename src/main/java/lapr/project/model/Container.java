package lapr.project.model;

/**
 * Represents a Container
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class Container {

    /**
     * Represents the X coordinate where the container is placed in the ship
     */
    private int coordinateX;

    /**
     * Represents the Y coordinate where the container is placed in the ship
     */
    private int coordinateY;

    /**
     * Represents the Z coordinate where the container is placed in the ship
     */
    private int coordinateZ;

    /**
     * The number that identify the container
     */
    private String number;

    /**
     * The check digit that identify the container
     */
    private int checkDigit;

    /**
     * The isoCode that identify the container
     */
    private String isoCode;

    /**
     * The maximum weight a container can carry
     */
    private float maximumWeight;

    /**
     * The payload of a container
     */
    private float payload;

    /**
     * The tare of a container
     */
    private float tare;

    /**
     * The weight of a container
     */
    private float weight;

    /**
     * The maximum weight that a container can pack
     */
    private float maxWeightPacked;

    /**
     * The maximum volume that a container can pack
     */
    private float maxVolumePacked;

    /**
     * The repair recommendation of a container
     */
    private String repairRecommendation;

    /**
     * The certificate of a container
     */
    private String certificate;

    /**
     * Creates an instance of Container
     * @param coordinateX
     * @param coordinateY
     * @param coordinateZ
     * @param number
     * @param checkDigit
     * @param isoCode
     * @param maximumWeight
     * @param payload
     * @param tare
     * @param weight
     * @param maxWeightPacked
     * @param maxVolumePacked
     * @param repairRecommendation
     * @param certificate
     */
    public Container(int coordinateX, int coordinateY, int coordinateZ, String number, int checkDigit, String isoCode, float maximumWeight, float payload, float tare, float weight, float maxWeightPacked, float maxVolumePacked, String repairRecommendation, String certificate) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
        this.number = number;
        this.checkDigit = checkDigit;
        this.isoCode = isoCode;
        this.maximumWeight = maximumWeight;
        this.payload = payload;
        this.tare = tare;
        this.weight = weight;
        this.maxWeightPacked = maxWeightPacked;
        this.maxVolumePacked = maxVolumePacked;
        this.repairRecommendation = repairRecommendation;
        this.certificate = certificate;
    }

    /**
     * Creates an instance of Container
     * @param container
     */
    public Container(Container container) {
        this.coordinateX = container.getCoordinateX();
        this.coordinateY = container.getCoordinateY();
        this.coordinateZ = container.getCoordinateZ();
        this.number = container.getNumber();
        this.checkDigit = container.getCheckDigit();
        this.isoCode = container.getIsoCode();
        this.maximumWeight = container.getMaximumWeight();
        this.payload = container.getPayload();
        this.tare = container.getTare();
        this.weight = container.getWeight();
        this.maxWeightPacked = container.getMaxWeightPacked();
        this.maxVolumePacked = container.getMaxVolumePacked();
        this.repairRecommendation = container.getRepairRecommendation();
        this.certificate = container.getCertificate();
    }

    /**
     * get the x coordinate of a container
     * @return the x coordinate
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * get the y coordinate of a container
     * @return the y coordinate
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * get the z coordinate  of a container
     * @return the z coordinate
     */
    public int getCoordinateZ() {
        return coordinateZ;
    }

    /**
     * get the number of a container
     * @return the container number
     */
    public String getNumber() {
        return number;
    }

    /**
     * get the check digit of a container
     * @return the check digit of the container
     */
    public int getCheckDigit() {
        return checkDigit;
    }

    /**
     * get the iso code of a container
     * @return the iso code
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     * get the maximum weight of a container
     * @return the maximum weight
     */
    public float getMaximumWeight() {
        return maximumWeight;
    }

    /**
     * get the payload of a container
     * @return the payload
     */
    public float getPayload() {
        return payload;
    }

    /**
     * get the tare of a container
     * @return the container
     */
    public float getTare() {
        return tare;
    }

    /**
     * get the weight of a container
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * get the maximum weight packed by a container
     * @return the maximum weight packed
     */
    public float getMaxWeightPacked() {
        return maxWeightPacked;
    }

    /**
     * get the maximum volume packed by a container
     * @return the maximum value packed
     */
    public float getMaxVolumePacked() {
        return maxVolumePacked;
    }

    /**
     * get the repair recommendation of a container
     * @return the repair recommendation
     */
    public String getRepairRecommendation() {
        return repairRecommendation;
    }

    /**
     * get the certificate of a container
     * @return the certificate of a container
     */
    public String getCertificate() {
        return certificate;
    }
}
