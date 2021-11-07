package lapr.project.mapper.dto;

import lapr.project.model.Ship;

import java.util.Objects;

/**
 * Represents a data transfer object of Ship
 * @author Pedro Rocha <1201382@isep.ipp.pt>
 */
public class ShipDetailsDto {

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
    private float capacity; //in m^3

    /**
     * The ship's draft
     */
    private float draft;

    /**
     * Ship's Details Dto constructor
     *
     * @param MMSI
     * @param name
     * @param shipID
     * @param callSign
     * @param vesselType
     * @param length
     * @param width
     * @param draft
     */
    public ShipDetailsDto(String MMSI, String name, String shipID, String callSign,
                          int vesselType, float length, float width, float draft){
        setMMSI(MMSI);
        setName(name);
        setShipID(shipID);
        //setNumberGenerators(energyGenerators);
        //setGeneratorOutput(generatorOutput);
        setCallSign(callSign);
        this.vesselType = vesselType;
        setLength(length);
        setWidth(width);
        //setCapacity(capacity);
        setDraft(draft);

    }

    /**
     * Ship's Details Dto Constructor
     *
     * @param ship
     */
    public ShipDetailsDto(Ship ship) {
        setMMSI(ship.getMMSI());
        setName(ship.getName());
        setShipID(ship.getShipID());
        //setNumberGenerators(ship.getEnergyGenerators());
        //setGeneratorOutput(ship.getGeneratorOutput());
        setCallSign(ship.getCallSign());
        this.vesselType = ship.getVesselType();
        setLength(ship.getLength());
        setWidth(ship.getWidth());
        //setCapacity(ship.getCapacity());
        setDraft(ship.getDraft());
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
        if(shipID == null || shipID.length() != 10)
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
        if(energyGenerators <= 0)
            throw new IllegalArgumentException("The ship cannot have 0 or less generators.");
        else this.energyGenerators = energyGenerators;
    }

    /**
     * Sets the Ship's generator output according to the defined rules
     *
     * @param generatorOutput
     */
    public void setGeneratorOutput(float generatorOutput){
        if(generatorOutput <= 0)
            throw new IllegalArgumentException("The ship cannot have a power output lower or equal to 0");
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
        if(capacity <= 0)
            throw new IllegalArgumentException("A Ship must have a capacity bigger than 0.");
        else
            this.capacity = capacity;
    }

    /**
     * Sets the Ship's draft according to the defined rules
     *
     * @param draft
     */
    public void setDraft(float draft){
        if(draft <= 0)
            throw new IllegalArgumentException("A ship must have a bigger draft than 0. Otherwise, you will end up with a submarine.\n:)");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipDetailsDto)) return false;
        ShipDetailsDto that = (ShipDetailsDto) o;
        return energyGenerators == that.energyGenerators && Float.compare(that.generatorOutput, generatorOutput) == 0 && vesselType == that.vesselType && Float.compare(that.length, length) == 0 && Float.compare(that.width, width) == 0 && Float.compare(that.capacity, capacity) == 0 && Float.compare(that.draft, draft) == 0 && Objects.equals(MMSI, that.MMSI) && Objects.equals(name, that.name) && Objects.equals(shipID, that.shipID) && Objects.equals(callSign, that.callSign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MMSI, name, shipID, energyGenerators, generatorOutput, callSign, vesselType, length, width, capacity, draft);
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
     * @return information about a certain ship
     */
    @Override
    public String toString() {
        return  "MMSI: " + MMSI +
                " \nName: " + name +
                " \nIMO: " + shipID +
                " \nCall Sign: " + callSign +
                " \nVessel Type: " + vesselType +
                " \nLength: " + length +
                " \nWidth: " + width +
                " \nDraft: " + draft;
    }
}
