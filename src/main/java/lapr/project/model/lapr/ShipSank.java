package lapr.project.model.lapr;

public class ShipSank {

    private final double DENSITY = 1.03;
    private final double CONTAINER_MASS = 0.5;

    private double vesselEmptyVolume;
    private double vesselLoadedVolume;
    private double shipSankHeight;


    public ShipSank(){
        this.vesselEmptyVolume = 0;
        this.vesselLoadedVolume = 0;
        this.shipSankHeight = 0;
    }
    /**
     * This method returns the volume of the Vessel without conteiners.
     * @param vesselMass
     * @param containers
     * @return Vessel Volume with 0 containers
     */
    public double vesselVolume (double vesselMass, int containers){
        double volume;
        volume = (vesselMass + (containers * CONTAINER_MASS))/DENSITY;
        return volume;
    }

    /**
     * This method returns the Height the Vessel sank when the containers are loaded.
     * @param vesselMass
     * @param width
     * @param length
     * @param containers
     * @return Sank Height
     */
    public void shipSankHeight (double vesselMass, double width, double length, int containers) {
        double vesselEmptyVolume, vesselLoadedVolume, initialHeight, finalHeight;

        vesselEmptyVolume = vesselVolume(vesselMass,0);
        this.vesselEmptyVolume = vesselEmptyVolume;
        vesselLoadedVolume = vesselVolume(vesselMass,containers);
        this.vesselLoadedVolume = vesselLoadedVolume;

        initialHeight = vesselEmptyVolume / (length * width);
        finalHeight = vesselLoadedVolume / (length * width);
        this.shipSankHeight = (initialHeight - finalHeight);
    }

    public double getVesselEmptyVolume() {
        return vesselEmptyVolume;
    }
    public double getVesselLoadedVolume() {
        return vesselLoadedVolume;
    }
    public double getShipSankHeight() {
        return shipSankHeight;
    }












}
