package graph.saveMode;

import java.util.List;

public interface GraphMtx<T> {
    void insertVertex(T value);
    void insertEdge(T start,T end, int weight);
    void insertType(boolean type);
    void init();
    int[][] getGraphMtx();
    List<T> graphDh(int[][] graphMtx,T value);
}
