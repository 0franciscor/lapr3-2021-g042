package lapr.project.model;

/**
 *
 * @author 1201239 Francisco Redol
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class Ship implements Comparable<Ship> {

    private String MMSI;

    private String name;

    private String shipID;

    private int energyGenerators;

    private float generatorOutput;

    private String callSign;

    private int vesselType;

    private float length;

    private float width;

    private float capacity;

    private float draft;

    private ShipLocationBST shipLocationBST; //Dynamical fields according to the location of the ship, are stored in a dedicated class, called ShipLocation


    public Ship(){}

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

    public void setMMSI(String MMSI){
        if(MMSI == null || MMSI.length() != 9)
            throw new IllegalArgumentException("The ship MMSI code must be 9-digit long.");
        else
            this.MMSI = MMSI;
    }

    public void setName(String name){
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("The Ship name cannot be empty.");
        else
            this.name = name;
    }

    public void setShipID(String shipID){
        if(shipID == null || shipID.length() != 7)
            throw new IllegalArgumentException("The shipID code must be 7-digit long.");
        else
            this.shipID = shipID;
    }

    public void setNumberGenerators(int energyGenerators){
        if(energyGenerators <= 0)
            throw new IllegalArgumentException("The ship cannot have 0 or less generators.");
        else this.energyGenerators = energyGenerators;
    }

    public void setGeneratorOutput(float generatorOutput){
        if(generatorOutput <= 0)
            throw new IllegalArgumentException("The ship cannot have a power output lower or equal to 0");
        else this.generatorOutput = generatorOutput;
    }

    public void setCallSign (String callSign){
        if(callSign == null || callSign.isEmpty())
            throw new IllegalArgumentException("The Ship call sign cannot be empty.");
        else
            this.callSign = callSign;
    }

    public void setLength (float length){
        if(length <= 0)
            throw new IllegalArgumentException("A Ship must have a length bigger than 0.");
        else
            this.length = length;
    }

    public void setWidth(float width){
        if(width <= 0)
            throw new IllegalArgumentException("A Ship must have a width bigger than 0.");
        this.width = width;

    }

    public void setCapacity (float capacity){
        if(capacity <= 0)
            throw new IllegalArgumentException("A Ship must have a capacity bigger than 0.");
        else
            this.capacity = capacity;
    }

    public void setDraft(float draft){
        if(draft <= 0)
            throw new IllegalArgumentException("A ship must have a bigger draft than 0. Otherwise, you will end up with a submarine.\n:)");
        else
            this.draft = draft;
    }

    public String getMMSI(){
        return MMSI;
    }

    public String getName(){
        return name;
    }

    public String getShipID(){
        return shipID;
    }

    public int getEnergyGenerators(){
        return energyGenerators;
    }

    public float getGeneratorOutput(){
        return generatorOutput;
    }

    public String getCallSign(){
        return callSign;
    }

    public int getVesselType(){
        return vesselType;
    }

    public float getLength(){
        return length;
    }

    public float getWidth(){
        return width;
    }

    public float getCapacity(){
        return capacity;
    }

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

    @Override
    public int compareTo(Ship o) {
        return this.MMSI.compareTo(o.getMMSI());
    }


}
