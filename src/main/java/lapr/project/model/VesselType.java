package lapr.project.model;

/**
 * VesselType, a class which identify physical characteristics of several ships
 */
public class VesselType {

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
     * VesselType Constructor
     */
    public VesselType(){}

    /**
     * VesselType Constructor
     *
     * @param vesselType
     * @param length
     * @param width
     * @param capacity
     * @param draft
     */
    public VesselType(int vesselType, float length, float width, float capacity, float draft){
        this.vesselType = vesselType;
        setLength(length);
        setWidth(width);
        setCapacity(capacity);
        setDraft(draft);
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
     * @return the ship's Vessel Type
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
}
