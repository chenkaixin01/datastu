package graph;

import graph.bean.Vertex;
import graph.saveMode.GraphLnk;
import graph.saveMode.GraphLnkImpl;
import graph.saveMode.GraphMtx;
import graph.saveMode.GraphMtxImpl;
import util.Node;

import java.io.PrintStream;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GraphMtx<String> mtx= new GraphMtxImpl<>();
        mtx.insertType(false);
        mtx.insertVertex("A");
        mtx.insertVertex("B");
        mtx.insertVertex("C");
        mtx.insertVertex("D");
        mtx.insertVertex("E");
        mtx.insertVertex("F");
        mtx.insertVertex("G");
        mtx.init();
        mtx.insertEdge("A","B",1);
        mtx.insertEdge("A","D",1);
        mtx.insertEdge("B","C",1);
        mtx.insertEdge("B","E",1);
        mtx.insertEdge("C","D",1);
        mtx.insertEdge("D","E",1);
        mtx.insertEdge("F","G",1);
        int[][] grarp = mtx.getGraphMtx();
        for (int i=0; i<grarp.length;i++){
            for (int j=0; j<grarp[i].length; j++){
                System.out.printf(String.valueOf(grarp[i][j])+" ");
            }
            System.out.println(" ");
        }
        List<String> list = mtx.graphDh(grarp,"A");
        System.out.println("深度优先");
        for (String value: list){
            System.out.printf(value+" ");
        }
        System.out.println("");
        System.out.println("");


        GraphLnk<String> lnk = new GraphLnkImpl<>();
        lnk.insertType(true);
        lnk.insertVertex("A");
        lnk.insertVertex("B");
        lnk.insertVertex("C");
        lnk.insertVertex("D");
        lnk.insertVertex("E");
        lnk.insertVertex("F");
        lnk.insertVertex("G");
        lnk.insertEdge("A","C",1);
        lnk.insertEdge("C","A",1);
        lnk.insertEdge("C","E",1);
        lnk.insertEdge("B","C",1);
        lnk.insertEdge("B","D",1);
        lnk.insertEdge("D","C",1);
        lnk.insertEdge("E","F",1);
        lnk.insertEdge("E","G",1);
        lnk.insertEdge("F","G",1);
        List<Node<Vertex<String>>> grarpLnk = lnk.getGraphLnk();
        for(Node<Vertex<String>> node: grarpLnk){
            Node<Vertex<String>> tmp = node;
            while(tmp!=null){
                System.out.printf(tmp.getValue().getValue() + " ");
                tmp = tmp.getLeftChild();
            }
            System.out.println(" ");
        }
        List<String> listLnk = lnk.graphBFS(grarpLnk,"A");
        System.out.println("广度优先");
        for (String value: listLnk  ) {
            System.out.printf(value+" ");
        }
    }
}
