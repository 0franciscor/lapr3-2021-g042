package lapr.project.mapper.dto;

import lapr.project.model.Ship;

/**
 * Represents a data transfer object of Ship
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ShipDto {

    private String MMSI;

    private String name;

    private String shipID;

    private int energyGenerators;

    private float generatorOutput;

    private String callSign;

    private int vesselType;

    private float length;

    private float width;

    private float capacity; //in m^3

    private float draft;


    public ShipDto(String MMSI, String name, String shipID, int energyGenerators, float generatorOutput, String callSign,
                int vesselType, float length, float width, float capacity, float draft){
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

    }

    public ShipDto(Ship ship) {
        setMMSI(ship.getMMSI());
        setName(ship.getName());
        setShipID(ship.getShipID());
        setNumberGenerators(ship.getEnergyGenerators());
        setGeneratorOutput(ship.getGeneratorOutput());
        setCallSign(ship.getCallSign());
        this.vesselType = ship.getVesselType();
        setLength(ship.getLength());
        setWidth(ship.getWidth());
        setCapacity(ship.getCapacity());
        setDraft(ship.getDraft());
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


    @Override
    public String toString() {
        return "ShipDto{" +
                "MMSI='" + MMSI + '\'' +
                ", name='" + name + '\'' +
                ", shipID='" + shipID + '\'' +
                ", energyGenerators=" + energyGenerators +
                ", generatorOutput=" + generatorOutput +
                ", callSign='" + callSign + '\'' +
                ", vesselType=" + vesselType +
                ", length=" + length +
                ", width=" + width +
                ", capacity=" + capacity +
                ", draft=" + draft +
                '}';
    }
}
