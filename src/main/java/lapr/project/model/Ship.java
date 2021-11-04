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
     * The ship's ID
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
    private int vesselType;

    /**
     * The ship's length
     */
    private float length;

    /**
     * The ship's width
     */
    private float width;

    /**
     * The ship's capacity
     */
    private float capacity;

    /**
     * The ship's draft
     */
    private float draft;

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
     * @param vesselType
     * @param length
     * @param width
     * @param capacity
     * @param draft
     * @param shipLocation
     */
    public Ship(String MMSI, String name, String shipID, int energyGenerators, float generatorOutput, String callSign,
                int vesselType, float length, float width, float capacity, float draft, ShipLocation shipLocation){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        setNumberGenerators(energyGenerators);
        setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        this.vesselType = vesselType;
        setLength(length);
        setWidth(width);
        setCapacity(capacity);
        setDraft(draft);
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
     * @param vesselType
     * @param length
     * @param width
     * @param capacity
     * @param draft
     * @param shipLocationBST
     */
    public Ship(String MMSI, String name, String shipID, int energyGenerators, float generatorOutput, String callSign,
                int vesselType, float length, float width, float capacity, float draft, ShipLocationBST shipLocationBST){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        setNumberGenerators(energyGenerators);
        setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        this.vesselType = vesselType;
        setLength(length);
        setWidth(width);
        setCapacity(capacity);
        setDraft(draft);
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
     * Sets the Ship's length according to the defined rules
     *
     * @param length
     */
    public void setLength (float length){
        if(length <= 0)
            throw new IllegalArgumentException("A Ship must have a length bigger than 0.");
        else
            this.length = length;
    }

    /**
     * Sets the Ship's width according to the defined rules
     *
     * @param width
     */
    public void setWidth(float width){
        if(width <= 0)
            throw new IllegalArgumentException("A Ship must have a width bigger than 0.");
        this.width = width;

    }

    /**
     * Sets the Ship's capacity according to the defined rules
     *
     * @param capacity
     */
    public void setCapacity (float capacity){
        if(capacity < 0)
            throw new IllegalArgumentException("A Ship must have a capacity lower than 0.");
        else
            this.capacity = capacity;
    }

    /**
     * Sets the Ship's draft according to the defined rules
     *
     * @param draft
     */
    public void setDraft(float draft){
        if(draft < 0)
            throw new IllegalArgumentException("A ship cannot have a draft lower than 0. Otherwise, you will end up with a submarine.\n:)");
        else
            this.draft = draft;
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
     * @return the ship's vessel type
     */
    public int getVesselType(){
        return vesselType;
    }

    /**
     * @return the ship's length
     */
    public float getLength(){
        return length;
    }

    /**
     * @return the ship's width
     */
    public float getWidth(){
        return width;
    }

    /**
     * @return the ship's capacity
     */
    public float getCapacity(){
        return capacity;
    }

    /**
     * @return the ship's draft
     */
    public float getDraft(){
        return draft;
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

}