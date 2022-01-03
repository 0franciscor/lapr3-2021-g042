package lapr.project.model.esinf;

import lapr.project.model.*;
import lapr.project.model.store.BorderStore;
import lapr.project.model.store.CapitalStore;
import lapr.project.model.store.PortStore;
import lapr.project.model.store.SeadistStore;
import lapr.project.ui.Utils;
import lapr.project.utils.Graph;

import java.util.*;

public class FreightNetwork {

    private int coresUtilizadas;

    public AdjacencyMatrixGraph<Place, Double> adjacencyMatrixGraph;


    public FreightNetwork(){
        adjacencyMatrixGraph = new AdjacencyMatrixGraph<>(true);
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
                    adjacencyMatrixGraph.addEdge(capital2,capital,distance);

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
                adjacencyMatrixGraph.addEdge(ports2,ports1,distance);
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
                adjacencyMatrixGraph.addEdge(aux,capital,shortestDistance);
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


    public Map<Capital, Integer> colorNetwork(){
        //mapa onde guarda os locais e respetiva cor
        Map<Capital, Integer> resultado = new TreeMap();

        //criar e preencher a lista de capitais
        Map<Capital,Integer> capitalsUnordered = new LinkedHashMap<>();

        for (Place place: adjacencyMatrixGraph.vertices()){
            if (place instanceof Capital){
                int degree=0;
                for (Place place1 : adjacencyMatrixGraph.adjVertices(place)){
                    if (place1 instanceof Capital){
                        degree++;
                    }
                }
                capitalsUnordered.put((Capital) place,degree);
            }
        }

        //ordenar Lista de locais pelo numero do grau
        List<Map.Entry<Capital,Integer>> capitalsOrdered = new ArrayList<>(capitalsUnordered.entrySet());
        capitalsOrdered.sort(Map.Entry.<Capital,Integer> comparingByValue().reversed());

        // colorir o grafo
        int corAtual = 0;

        while (!isFullyColored(resultado, capitalsOrdered)) {
            for (Map.Entry<Capital, Integer> map : capitalsOrdered) {
                if (!resultado.containsKey(map.getKey())) {
                    boolean flag = true;
                    for (Place place : adjacencyMatrixGraph.adjVertices(map.getKey())) {
                        if (place instanceof Capital) {
                            if (resultado.containsKey(place) && resultado.get(place) == corAtual) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        resultado.put(map.getKey(), corAtual);
                    }
                }
            }
            corAtual++;
        }
        coresUtilizadas=corAtual;
        return resultado;
    }

    private boolean isFullyColored(Map<Capital, Integer> resultado,List<Map.Entry<Capital,Integer>> capitalsOrdered ) {
        for (Map.Entry<Capital, Integer> map : capitalsOrdered) {
            if (!resultado.containsKey(map.getKey())) {
                return false;
            }
        }
        return true;
    }

    public int getCoresUtilizadas(){
        return coresUtilizadas;
    }

    public List<Place> mostCenteredCities(int n){
        List<List<Place>>  places = new ArrayList<>();


        places.add(mostCenteredCitiesOnTheContinent(n,"Europe"));

        return mostCenteredCitiesOnTheContinent(n,"Europe");
    }

    public List<Place> mostCenteredCitiesOnTheContinent(int n, String continentName){

        Graph<Place, Double> graph = adjacencyMatrixGraph.clone();

        List<Place> centeredPlaces = new ArrayList<>();

        // obter só os locais de determinado continente
        for (Place p : adjacencyMatrixGraph.vertices()) {
            if (!p.getContinent().equals(continentName)) {
                graph.removeVertex(p);
            } else {
                centeredPlaces.add(p);
            }
        }

        AdjacencyMatrixGraph<Place, Double> matrixGraph = GraphAlgorithms.minDistGraph(graph,Double::compare, Double::sum);
        System.out.println(matrixGraph.toString());

        for (Place p : centeredPlaces){
            System.out.println(p);
            System.out.println(mediaDist(p,matrixGraph));
            System.out.println("-----");
        }
        // ordenar os locais de ordem crescente de centralidade
        centeredPlaces.sort(new Comparator<Place>() {
            @Override
            public int compare(Place c1, Place c2) {
                double a = mediaDist(c1,matrixGraph);
                double b = mediaDist(c2,matrixGraph);
                if(c1 instanceof Ports){
                    System.out.println(((Ports) c1).getPortName());
                    System.out.println(a);
                } else if (c1 instanceof Capital) {
                    System.out.println(((Capital) c1).getName());
                    System.out.println(a);
                }

                if(c2 instanceof Ports){
                    System.out.println(((Ports) c2).getPortName());
                    System.out.println(b);
                } else if (c2 instanceof Capital) {
                    System.out.println(((Capital) c2).getName());
                    System.out.println(b);
                }

                return Double.compare(a, b);
            }
        });


        // retornar os n locais de centralidade de proximidade do continente
        if (centeredPlaces.size() < n) {
            n = centeredPlaces.size();
        }
        return centeredPlaces.subList(0, n);

    }


    public double mediaDist(Place p, AdjacencyMatrixGraph<Place, Double> matrixGraph) {
        double contador = 0;
        int key = matrixGraph.key(p);
        for(int i=0; i<matrixGraph.numVertices(); i++){
            if(i!=key){
                if(matrixGraph.edge(p,matrixGraph.vertex(i)) != null) {
                    contador += matrixGraph.edge(p, matrixGraph.vertex(i)).getWeight();

                } else if (matrixGraph.edge(matrixGraph.vertex(i),p) != null){
                    contador += matrixGraph.edge(matrixGraph.vertex(i),p).getWeight();

                }
            }
        }
        return contador / (matrixGraph.numVertices() - 1);
    }

}
