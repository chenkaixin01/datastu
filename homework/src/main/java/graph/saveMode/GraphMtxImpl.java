package graph.saveMode;

import graph.bean.Edge;
import graph.bean.Vertex;

import java.util.*;

public class GraphMtxImpl<T> implements GraphMtx<T> {
    private boolean type = false;
    private Set<Vertex<T>> vertices = new HashSet<>();
    private Set<Edge<T>> edges = new HashSet<>();
    private int count = 0;
    int[][] graphMtx;

    @Override
    public void insertVertex(T value) {
        if(vertices.add(new Vertex<>(this.count,value))){
            this.count++;
        }
    }

    @Override
    public void insertEdge(T start, T end ,int weight) {
        Vertex<T> startVrtx = null;
        Vertex<T> endVrtx = null;
        boolean bStart = false;
        boolean bEnd = false;
        for (Vertex<T> vertex:vertices) {
            if(vertex.getValue().equals(start)){
                startVrtx = vertex;
                bStart = true;
            }
            if(vertex.getValue().equals(end)){
                endVrtx = vertex;
                bEnd = true;
            }
            if(bEnd&&bStart){
                break;
            }
        }
       if(edges.add(new Edge<T>(startVrtx, endVrtx, weight))) {
           if(startVrtx == null||endVrtx == null){
               return;
           }
           if(type){
               this.graphMtx[startVrtx.getIndex()][endVrtx.getIndex()]=weight;
           }else {
               this.graphMtx[startVrtx.getIndex()][endVrtx.getIndex()]=weight;
               this.graphMtx[endVrtx.getIndex()][startVrtx.getIndex()]=weight;
           }
       }

    }

    @Override
    public void init() {
        this.graphMtx = new int[vertices.size()][vertices.size()];
    }

    @Override
    public void insertType(boolean type) {
        this.type = type;
    }

    @Override
    public int[][] getGraphMtx() {
        return this.graphMtx;
    }

    Set<T> vertexSet = new HashSet<>();

    @Override
    public List<T> graphDh(int[][] graphMtx, T value) {
        Vertex<T>[] verticesArr = new Vertex[this.vertices.size()];
        List<T> list = new ArrayList<>();
        Vertex<T> first = null;
        for (Vertex<T> vertex: this.vertices ) {
            verticesArr[vertex.getIndex()] = vertex;
            if (value.equals(vertex.getValue())){
                first = vertex;
            }
        }
        graphDh(verticesArr,graphMtx,first,list);

        for(Vertex<T> vertex :verticesArr){
            if(this.vertexSet.add(vertex.getValue())){
                graphDh(verticesArr,graphMtx,vertex,list);
            }
        }
        return list;
    }

    private void graphDh(Vertex<T>[] verticesArr, int[][] graphMtx, Vertex<T> vertex, List<T> list) {
        if(vertex!=null){
            list.add(vertex.getValue());
            this.vertexSet.add(vertex.getValue());
        }
        for (int i=0; i<graphMtx[vertex.getIndex()].length; i++){
            if(graphMtx[vertex.getIndex()][i]!=0){
                if(vertexSet.add(verticesArr[i].getValue())){
                    graphDh(verticesArr,graphMtx,verticesArr[i],list);
                }
            }
        }
    }
}
