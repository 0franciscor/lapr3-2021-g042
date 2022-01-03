package lapr.project.model.esinf;

import lapr.project.utils.Graph;


import java.util.Comparator;

import java.util.function.BinaryOperator;

public class GraphAlgorithms {


    /** Calculates the minimum distance graph using Floyd-Warshall
     *
     * @param g initial graph
     * @param ce comparator between elements of type E
     * @param sum sum two elements of type E
     * @return the minimum distance graph
     */
    public static <V,E> AdjacencyMatrixGraph <V,E> minDistGraph(Graph <V,E> g, Comparator<E> ce, BinaryOperator<E> sum) {
        int nV = g.numVertices();
        int i;
        int j;
        int k;

        if (nV == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E[][] mat = (E[][]) new Object[nV][nV];

        // preencher a matriz com as ligações já presentes no grafo
        for (i = 0; i < nV; i++) {
            for (j = 0; j < nV; j++) {
                Edge<E, V> edge = (Edge<E, V>) g.edge(i, j);
                if (edge != null) {
                    mat[i][j] = (E) edge.getWeight();
                }
            }
        }

        //preencher com os caminhos mais curtos
        for(k=0; k < nV; k++){
            for(i=0; i<nV; i++){
                if(i!=k && mat[i][k]!=null){
                    for(j=0; j<nV; j++){
                        if(i!=j && k!=j && mat[k][j]!=null){
                            E s = sum.apply(mat[i][k],mat[k][j]);

                            if(mat[i][j] == null || ce.compare(mat[i][j],s) > 0){
                                mat[i][j] =s;
                            }
                        }
                    }
                }
            }
        }

        return new AdjacencyMatrixGraph<>(g.isDirected(), g.vertices(), mat);
    }


}
