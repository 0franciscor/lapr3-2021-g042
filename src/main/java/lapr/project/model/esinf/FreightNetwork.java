package lapr.project.model.esinf;

import lapr.project.model.*;
import lapr.project.model.store.*;
import lapr.project.ui.Utils;

import java.util.*;

public class FreightNetwork {


    public AdjacencyMatrixGraph<Place, Double> adjacencyMatrixGraph;


    public FreightNetwork(){
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(false);
    }


    public AdjacencyMatrixGraph<Place,Double> getAdjacencyMatrixGraph(){
        return adjacencyMatrixGraph;
    }

    public void addNewInformation(CapitalStore capitalStore, PortStore portStore, SeadistStore seadistStore, BorderStore borderStore, int n){
        linkBetweenCapitalsOfNeighboringCountries(capitalStore,borderStore);
        connectionBetweenPortsOfTheSameCountry(portStore,seadistStore);
        connectionBetweenTheCapitalAndTheNearestPort(capitalStore,portStore);
        connectionBetweenThePortAndTheNearestNPortsOfAnotherCountry(seadistStore,n,portStore);
    }

    protected void linkBetweenCapitalsOfNeighboringCountries(CapitalStore capitalStore,BorderStore borderStore){
        for (Capital capital: capitalStore.getCapitalLst()){
            for (Border border: borderStore.getBorderLst()){
                if (border.getCountryName().equals(capital.getCountryName())){
                    Capital capital2 = capitalStore.getCapitalByCountryName(border.getCountryName2());
                    Double distance = Utils.calculateDistance(capital.getLatitude(),capital.getLongitude(),capital2.getLatitude(),capital2.getLongitude());
                    adjacencyMatrixGraph.addEdge(capital,capital2,distance);
                }
            }
        }
    }

    protected void connectionBetweenPortsOfTheSameCountry(PortStore portStore,SeadistStore seadistStore){
        for (Seadist seadist: seadistStore.getSeadistLst()){
            if (seadist.getCountryName1().equals(seadist.getCountryName2())){
                double distance = seadist.getSeaDistance();
                Ports ports1 = portStore.getPortByName(seadist.getPortName1());
                Ports ports2 = portStore.getPortByName(seadist.getPortName2());
                adjacencyMatrixGraph.addEdge(ports1,ports2,distance);
            }
        }
    }

    protected void connectionBetweenTheCapitalAndTheNearestPort(CapitalStore capitalStore,PortStore portStore){
        for (Capital capital: capitalStore.getCapitalLst()){
            double shortestDistance = Double.POSITIVE_INFINITY;
            int count=0;
            Ports aux=null;
            for (Ports ports: portStore.getPortsLst()){
                if (capital.getCountryName().equals(ports.getCountryName())){
                    double distance = Utils.calculateDistance(capital.getLatitude(),capital.getLongitude(),ports.getLatitude(),ports.getLongitude());
                    if ( distance<shortestDistance){
                        shortestDistance=distance;
                        aux=ports;
                        count++;
                    }
                }
            }
            if (count != 0){
                adjacencyMatrixGraph.addEdge(capital,aux,shortestDistance);
            }
        }
    }

    protected void connectionBetweenThePortAndTheNearestNPortsOfAnotherCountry(SeadistStore seadistStore, int n,PortStore portStore){
        for (Ports ports: portStore.getPortsLst()){
            int count=0;
            TreeMap<Double, Ports> distanceList = new TreeMap<>();

            for (Seadist seadist: seadistStore.getSeadistLst()){
                if(!seadist.getCountryName1().equals(seadist.getCountryName2())){
                    if(ports.getPortName().equals(seadist.getPortName1()) || ports.getPortName().equals(seadist.getPortName2())){
                        double distance = seadist.getSeaDistance();
                        Ports ports1 = portStore.getPortByName(seadist.getPortName1());
                        Ports ports2 = portStore.getPortByName(seadist.getPortName2());
                        if (ports.getPortName().equals(seadist.getPortName1())){
                            distanceList.put(distance,ports2);
                            count++;
                        } else {
                            distanceList.put(distance,ports1);
                            count++;
                        }
                    }
                }
            }
            int temp;
            if (count < n) {
                temp = count;
            } else {
                temp = n;
            }

            for(int i=0; i<temp;i++){
                double dist = new Vector<>(distanceList.keySet()).get(i);
                Ports aux = new Vector<>(distanceList.values()).get(i);
                adjacencyMatrixGraph.addEdge(ports,aux,dist);
            }


        }
    }




    /*
    public void colorNetwork(){
        //mapa onde guarda os locais e respetiva cor
        Map<Place, Integer> resultado = new TreeMap();

        //criar e preencher a lista de paises
        List<Place> places = new LinkedList<>(adjacencyMatrixGraph.vertices());

        //ordenar Lista de locais pelo numero do grau
        for (int i = 0; i < places.size() - 1; i++) {
            int p1Degree = adjacencyMatrixGraph.outDegree(places.get(i));

            for (int j = i + 1; j < places.size(); j++) {
                int p2Degree = adjacencyMatrixGraph.outDegree(places.get(j));
                if (p1Degree < p2Degree) {
                    Place aux = places.get(i);
                    places.set(i, places.get(j));
                    places.set(j, aux);

                    p1Degree = adjacencyMatrixGraph.outDegree(places.get(i));
                }
            }
        }

    }

     */

}
