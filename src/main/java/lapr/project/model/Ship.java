package lapr.project.model;

/**
 *
 * @author 1201239 Francisco Redol
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class Ship implements Comparable<Ship> {

    /**
     * The ship's MMSI
     */
    private String MMSI;

    /**
     * The ship's name
     */
    private String name;

    /**
     * The ship's ID (IMO code)
     */
    private String shipID;

    /**
     * The ship's number of Energy Generators
     */
    private int energyGenerators;

    /**
     * The ship's Power Output
     */
    private float generatorOutput;

    /**
     * The ship's Call sign
     */
    private String callSign;

    /**
     * The ship's Vessel Type
     */
    private VesselType vesselType;

    /**
     * The Ship's Locations tree
     */
    private ShipLocationBST shipLocationBST; //Dynamical fields according to the location of the ship, are stored in a dedicated class, called ShipLocation


    /**
     * Empty Constructor
     */
    public Ship(){}

    /**
     * Ship's Constructor
     *
     * @param MMSI
     * @param name
     * @param shipID
     * @param energyGenerators
     * @param generatorOutput
     * @param callSign
     * @param shipLocation
     */
    public Ship(String MMSI, String name, String shipID, int energyGenerators,
                float generatorOutput, String callSign, ShipLocation shipLocation){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        setNumberGenerators(energyGenerators);
        setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        shipLocationBST = new ShipLocationBST();
        shipLocationBST.insert(shipLocation);
    }

    /**
     * Ship's Constructor
     *
     * @param MMSI
     * @param name
     * @param shipID
     * @param energyGenerators
     * @param generatorOutput
     * @param callSign
     * @param shipLocationBST
     */
    public Ship(String MMSI, String name, String shipID, int energyGenerators,
                float generatorOutput, String callSign, ShipLocationBST shipLocationBST){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        setNumberGenerators(energyGenerators);
        setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        this.shipLocationBST = shipLocationBST;
    }

    /**
     * Sets the Ship's MMSI according to the defined rules
     *
     * @param MMSI
     */
    public void setMMSI(String MMSI){
        if(MMSI == null || MMSI.length() != 9)
            throw new IllegalArgumentException("The ship MMSI code must be 9-digit long.");
        else
            this.MMSI = MMSI;
    }

    /**
     * Sets the Ship's name according to the defined rules
     *
     * @param name
     */
    public void setName(String name){
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("The Ship name cannot be empty.");
        else
            this.name = name;
    }

    /**
     * Sets the Ship's shipID according to the defined rules
     *
     * @param shipID
     */
    public void setShipID(String shipID){
        if(shipID == null || shipID.length() != 10 || !shipID.startsWith("IMO"))
            throw new IllegalArgumentException("The shipID code must be 7-digit long.");
        else
            this.shipID = shipID;
    }

    /**
     * Sets the Ship's number of Energy Generators according to the defined rules
     *
     * @param energyGenerators
     */
    public void setNumberGenerators(int energyGenerators){
        if(energyGenerators < 0)
            throw new IllegalArgumentException("The ship cannot have less than 0 generators.");
        else this.energyGenerators = energyGenerators;
    }

    /**
     * Sets the Ship's generator output according to the defined rules
     *
     * @param generatorOutput
     */
    public void setGeneratorOutput(float generatorOutput){
        if(generatorOutput < 0)
            throw new IllegalArgumentException("The ship cannot have a power output lower than 0");
        else this.generatorOutput = generatorOutput;
    }

    /**
     * Sets the Ship's Call Sign according to the defined rules
     *
     * @param callSign
     */
    public void setCallSign (String callSign){
        if(callSign == null || callSign.isEmpty())
            throw new IllegalArgumentException("The Ship call sign cannot be empty.");
        else
            this.callSign = callSign;
    }

    /**
     * @return ship's MMSI
     */
    public String getMMSI(){
        return MMSI;
    }

    /**
     * @return ship's name
     */
    public String getName(){
        return name;
    }

    /**
     * @return ship's ID
     */
    public String getShipID(){
        return shipID;
    }

    /**
     * @return ship's number of energy Generators
     */
    public int getEnergyGenerators(){
        return energyGenerators;
    }

    /**
     * @return ship's number of Generators' output
     */
    public float getGeneratorOutput(){
        return generatorOutput;
    }

    /**
     * @return the ship's call sign
     */
    public String getCallSign(){
        return callSign;
    }

    /**
     * @return the ship's Vessel Type
     */
    public int getVesselType(){
        return vesselType.getVesselType();
    }

    /**
     * @return the ship's length
     */
    public float getLength(){
        return vesselType.getLength();
    }

    /**
     * @return the ship's width
     */
    public float getWidth(){
        return vesselType.getWidth();
    }

    /**
     * @return the ship's capacity
     */
    public float getCapacity(){
        return vesselType.getCapacity();
    }

    /**
     * @return the ship's draft
     */
    public float getDraft(){
        return vesselType.getDraft();
    }

    /**
     * This method allows to obtain the BST of the different locations of the boat over time
     * @return BST with the various locations of the ship
     */
    public ShipLocationBST getShipPosition(){
        return shipLocationBST;
    }

    /**
     * @param o Other ship to compare
     *
     * Compares ships by MMSI
     *
     * @return the compareTo result of the MMSI
     */
    @Override
    public int compareTo(Ship o) {
        return this.MMSI.compareTo(o.getMMSI());
    }

    /**
     * @return information about a certain ship
     */
    @Override
    public String toString(){
        return String.format("MMSI: %s\nName: %s\nshipID: %s\nEnergy Generators: %d\nGenerator Output: %.2f\nCall Sign: %s\nVessel Type: %d\nLength: %.2f\n" +
                "Width: %.2f\nCapacity: %.2f\nDraft: %.2f\n", MMSI, name, shipID, energyGenerators, generatorOutput, callSign, getVesselType(), getLength(), getWidth(), getCapacity(), getDraft());
    }

}