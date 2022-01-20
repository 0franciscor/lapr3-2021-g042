package lapr.project.model.fsiap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForTheContainerAtTemperatureOf7DegreesAndMadeOfStainlessSteel{

    private HeatFlow heatFlow;
    private final double OUTER_LAYER_THICKNESS = 0.05;
    private final double MIDDLE_LAYER_THICKNESS = 0.12;
    private final double INNER_LAYER_THICKNESS = 0.05;
    private final double OUTER_LAYER_THERMAL_CONDUCTIVITY = 15;
    private final double MIDDLE_LAYER_THERMAL_CONDUCTIVITY = 0.035;
    private final double INNER_LAYER_THERMAL_CONDUCTIVITY = 0.21;
    private final double OUTSIDE_TEMPERATURE_US412 = 20;
    private final double OUTSIDE_TEMPERATURE_US413 = 30;
    private final double INSIDE_TEMPERATURE = 7;
    private final int NUMBER_OF_CONTAINERS = 20;

    @Test
    public void us412(){
        heatFlow = new HeatFlow();
        heatFlow.calculateNumerator(OUTSIDE_TEMPERATURE_US412, INSIDE_TEMPERATURE);
        heatFlow.calculateDenominator(OUTER_LAYER_THICKNESS, OUTER_LAYER_THERMAL_CONDUCTIVITY, MIDDLE_LAYER_THICKNESS, MIDDLE_LAYER_THERMAL_CONDUCTIVITY, INNER_LAYER_THICKNESS, INNER_LAYER_THERMAL_CONDUCTIVITY);
        heatFlow.calculateHeatFlow();
        heatFlow.totalEnergy(9000);

        double expectedResult = 31880.11;
        double result = heatFlow.getTotalEnergy();

        assertEquals(result, expectedResult, 0.01);
    }

    @Test
    public void us413(){
        heatFlow = new HeatFlow();
        heatFlow.calculateNumerator(OUTSIDE_TEMPERATURE_US413, INSIDE_TEMPERATURE);
        heatFlow.calculateDenominator(OUTER_LAYER_THICKNESS, OUTER_LAYER_THERMAL_CONDUCTIVITY, MIDDLE_LAYER_THICKNESS, MIDDLE_LAYER_THERMAL_CONDUCTIVITY, INNER_LAYER_THICKNESS, INNER_LAYER_THERMAL_CONDUCTIVITY);
        heatFlow.calculateHeatFlowForContainers(NUMBER_OF_CONTAINERS);
        heatFlow.totalEnergy(10800);

        double expectedResult = 1353678.47;
        double result = heatFlow.getTotalEnergy();

        assertEquals(result, expectedResult, 0.01);
    }

    @Test
    public void us414OneSideExposed(){
        heatFlow = new HeatFlow();
        heatFlow.calculateNumerator(OUTSIDE_TEMPERATURE_US412, INSIDE_TEMPERATURE);
        heatFlow.calculateDenominator(OUTER_LAYER_THICKNESS, OUTER_LAYER_THERMAL_CONDUCTIVITY, MIDDLE_LAYER_THICKNESS, MIDDLE_LAYER_THERMAL_CONDUCTIVITY, INNER_LAYER_THICKNESS, INNER_LAYER_THERMAL_CONDUCTIVITY);
        heatFlow.calculateHeatFlow();
        heatFlow.totalEnergy(3600);


        double expectedResult = 12752.04;
        double result = heatFlow.calculateEnergyForExposedSides(1);

        assertEquals(result, expectedResult, 0.01);
    }

    @Test
    public void us414TwoSidesExposed(){
        heatFlow = new HeatFlow();
        heatFlow.calculateNumerator(OUTSIDE_TEMPERATURE_US412, INSIDE_TEMPERATURE);
        heatFlow.calculateDenominator(OUTER_LAYER_THICKNESS, OUTER_LAYER_THERMAL_CONDUCTIVITY, MIDDLE_LAYER_THICKNESS, MIDDLE_LAYER_THERMAL_CONDUCTIVITY, INNER_LAYER_THICKNESS, INNER_LAYER_THERMAL_CONDUCTIVITY);
        heatFlow.calculateHeatFlow();
        heatFlow.totalEnergy(3600);


        double expectedResult = 25504.09;
        double result = heatFlow.calculateEnergyForExposedSides(2);

        assertEquals(result, expectedResult, 0.01);
    }

    @Test
    public void us414ThreeSidesExposed(){
        heatFlow = new HeatFlow();
        heatFlow.calculateNumerator(OUTSIDE_TEMPERATURE_US412, INSIDE_TEMPERATURE);
        heatFlow.calculateDenominator(OUTER_LAYER_THICKNESS, OUTER_LAYER_THERMAL_CONDUCTIVITY, MIDDLE_LAYER_THICKNESS, MIDDLE_LAYER_THERMAL_CONDUCTIVITY, INNER_LAYER_THICKNESS, INNER_LAYER_THERMAL_CONDUCTIVITY);
        heatFlow.calculateHeatFlow();
        heatFlow.totalEnergy(3600);


        double expectedResult = 38256.13;
        double result = heatFlow.calculateEnergyForExposedSides(3);

        assertEquals(result, expectedResult, 0.01);
    }



}
