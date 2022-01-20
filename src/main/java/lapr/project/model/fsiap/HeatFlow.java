package lapr.project.model.fsiap;

public class HeatFlow {

    private final double CROSS_SECTION_OF_AREA = 1.00;
    private double denominator;
    private double numerator;
    private double heatFlow;
    private double totalEnergy;

    public HeatFlow() {
        this.denominator = 0;
        this.numerator = 0;
        this.heatFlow = 0;
        this.heatFlow = 0;
    }

    public void calculateDenominator(double l1, double k1, double l2, double k2, double l3, double k3){
        /*
            L1 - outer layer thickness
            L2 - middle layer thickness
            L3 - inner layer thickness
            K1 - outer layer thermal conductivity
            K2 - middle layer thermal conductivity
            K3 - inner layer thermal conductivity
            Denominator = L1/K1 + L2/K2 + L3/K3
         */

        this.denominator = (l1/k1 + l2/k2 + l3/k3);
    }

    public void calculateNumerator(double outsideTemperature, double insideTemperature){

        /*
            temperature variation calculation
         */

        this.numerator = (CROSS_SECTION_OF_AREA * (outsideTemperature - insideTemperature));
    }

    public void calculateHeatFlow(){

        this.heatFlow = (numerator/denominator);
    }

    public void totalEnergy(int time){
        this.totalEnergy = (heatFlow * time);
    }

    public double getTotalEnergy() {
        return totalEnergy;
    }

    public void calculateHeatFlowForContainers(int numberOfContainers){
        calculateHeatFlow();
        this.heatFlow = (heatFlow * numberOfContainers);

    }

    public double calculateEnergyForExposedSides(int exposedSides){

        return (totalEnergy * exposedSides);
    }


}
