package lapr.project.model;

/**
 *
 * @author Francisco Redol <1201239@isep.ipp.pt>
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
     * The ship's capacity
     */
    private String capacity;

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
     * Ship Constructor
     *
     * @param MMSI The ship's MMSI
     * @param name The ship's name
     * @param shipID The ship's ID (IMO code)
     * @param energyGenerators The ship's number of Energy Generators
     * @param generatorOutput The ship's Power Output
     * @param callSign The ship's Call sign
     * @param vesselType The ship's Vessel Type
     * @param length The ship's length
     * @param width The ship's width
     * @param cargo The ship's capacity
     * @param draft The ship's draft
     * @param shipLocation The Ship's Locations tree
     */
    public Ship(String MMSI, String name, String shipID, int energyGenerators, float generatorOutput, String callSign,
                int vesselType, float length, float width, String cargo , float draft, ShipLocation shipLocation){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        setNumberGenerators(energyGenerators);
        setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        setCapacity(cargo);
        this.vesselType = new VesselType(vesselType, length, width, draft);
        shipLocationBST = new ShipLocationBST();
        shipLocationBST.insert(shipLocation);
    }

    /**
     * Ship constructor
     *
     * @param MMSI The ship's MMSI
     * @param name The ship's name
     * @param shipID The ship's ID (IMO code)
     * @param energyGenerators The ship's number of Energy Generators
     * @param generatorOutput The ship's Power Output
     * @param callSign The ship's Call sign
     * @param vesselType The ship's Vessel Type
     * @param length The ship's length
     * @param width The ship's width
     * @param cargo The ship's capacity
     * @param draft The ship's draft
     * @param shipLocationBST The Ship's Locations tree
     */
    public Ship(String MMSI, String name, String shipID, int energyGenerators, float generatorOutput, String callSign,
                int vesselType, float length, float width, String cargo , float draft, ShipLocationBST shipLocationBST){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        setNumberGenerators(energyGenerators);
        setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        setCapacity(cargo);
        this.vesselType = new VesselType(vesselType, length, width, draft);
        this.shipLocationBST = shipLocationBST;
    }

    /**
     * Sets the Ship's MMSI according to the defined rules
     *
     * @param MMSI The ship's MMSI
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
     * @param name The ship's name
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
     * @param shipID The ship's ID (IMO code)
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
     * @param energyGenerators The ship's number of Energy Generators
     */
    public void setNumberGenerators(int energyGenerators){
        if(energyGenerators < 0)
            throw new IllegalArgumentException("The ship cannot have less than 0 generators.");
        else this.energyGenerators = energyGenerators;
    }

    /**
     * Sets the Ship's generator output according to the defined rules
     *
     * @param generatorOutput The ship's Power Output
     */
    public void setGeneratorOutput(float generatorOutput){
        if(generatorOutput < 0)
            throw new IllegalArgumentException("The ship cannot have a power output lower than 0");
        else this.generatorOutput = generatorOutput;
    }

    /**
     * Sets the Ship's Call Sign according to the defined rules
     *
     * @param callSign The ship's Call sign
     */
    public void setCallSign (String callSign){
        if(callSign == null || callSign.isEmpty())
            throw new IllegalArgumentException("The Ship call sign cannot be empty.");
        else
            this.callSign = callSign;
    }

    /**
     * Sets the Ship's capacity according to the defined rules
     *
     * @param capacity ship's capacity
     */
    public void setCapacity (String capacity){
        if(capacity == null || capacity.isEmpty())
            throw new IllegalArgumentException("The Ship's capacity shall not be empty.");

        if(capacity.equals("NA"))
            this.capacity = capacity;

        else if(Float.parseFloat(capacity) < 0)
            throw new IllegalArgumentException("The Ship's capacity shall not be empty.");

        else
            this.capacity = capacity;
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
    public String getCapacity(){
        return capacity;
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
                "Width: %.2f\nCapacity: %s\nDraft: %.2f\n", MMSI, name, shipID, energyGenerators, generatorOutput, callSign, getVesselType(), getLength(), getWidth(), getCapacity(), getDraft());
    }

}