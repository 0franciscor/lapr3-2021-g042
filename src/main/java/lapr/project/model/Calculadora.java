package lapr.project.model;

import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    public static List<Double> getCenterMass(int numeroPartes, double massaTotal, double[] xInicial, double[] xFinal, double[] yInicial, double[] yFinal, String[] formasGeometricas) throws IOException {
        WriteForAFile writeForAFile = new WriteForAFile();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Coordinates of the Ship's Center of Mass\n");

        double[] areas = new double[numeroPartes];
        double areaTotal =0.0;
        for(int i=0; i<numeroPartes; i++){
            areas[i] = calcularArea(formasGeometricas[i],xInicial[i],xFinal[i],yInicial[i],yFinal[i]);
            areaTotal+=areas[i];
        }
        double[] massas = new double[numeroPartes];
        for (int i=0; i<numeroPartes;i++){
            massas[i] = calcularMassa(massaTotal,areas[i],areaTotal);
        }
        double[] centroMassaX = new double[numeroPartes];
        double[] centroMassaY = new double[numeroPartes];
        for (int i=0; i<numeroPartes;i++){
            double x = xFinal[i]-xInicial[i];
            double aux = x/2;
            centroMassaX[i]=xFinal[i]-aux;
            double y = yFinal[i]-yInicial[i];
            aux = y/2;
            centroMassaY[i]=yFinal[i]-aux;
        }
        double valorCentroMassaX = obterCentroMassaX(massaTotal,centroMassaX,massas);
        double valorCentroMassaY = obterCentroMassaY(massaTotal,centroMassaY,massas);

        List<Double> resultado = new ArrayList<>();
        resultado.add(valorCentroMassaX);
        resultado.add(valorCentroMassaY);

        stringBuilder.append("->X: " + String.format("%.2f",valorCentroMassaX) + " m\n");
        stringBuilder.append("->Y: " +  String.format("%.2f",valorCentroMassaY) + " m\n");
        writeForAFile.writeForAFile(stringBuilder.toString(), "US418_CentroDeMassa", new File(".\\outputs\\US418"), false);

        return resultado;


    }

    public static double calcularArea(String forma, double xInicial, double xFinal, double yInicial, double yFinal){
        if (forma.equalsIgnoreCase("Retangulo")){
            double x = xFinal-xInicial;
            double y = yFinal-yInicial;
            return  x*y;
        }
        return 0;
    }

    public static double calcularMassa(double massaTotal, double areaIndividual, double areaTotal){
        double num = areaIndividual*massaTotal;
        return num/areaTotal;
    }

    public static double obterCentroMassaX(double massaTotal, double[] centroMassaX, double[] massas){
        double num = 0.0;

        for(int i=0; i<centroMassaX.length;i++){
            num += massas[i] * centroMassaX[i];
        }
        return num/massaTotal;
    }

    public static double obterCentroMassaY(double massaTotal, double[] centroMassaY, double[] massas){
        double num = 0.0;

        for(int i=0; i<centroMassaY.length;i++){
            num += massas[i] * centroMassaY[i];
        }
        return num/massaTotal;
    }


}
