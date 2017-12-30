package graph.saveMode;

import graph.bean.Vertex;
import util.Node;

import java.util.List;

public interface GraphLnk<T> {
    void insertVertex(T value);
    void insertEdge(T start,T end, int weight);
    void insertType(boolean type);
    List<Node<Vertex<T>>> getGraphLnk();
    List<T> graphBFS(List<Node<Vertex<T>>> graphLnk, T value);
}
