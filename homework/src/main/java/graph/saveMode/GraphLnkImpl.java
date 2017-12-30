package graph.saveMode;

import graph.bean.Vertex;
import util.Node;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphLnkImpl<T> implements GraphLnk<T> {
    private List<Node<Vertex<T>>> nodes = new ArrayList<>();
    private boolean type = false;

    @Override
    public void insertVertex(T value) {
        int count = 0;
        Node<Vertex<T>> node = new Node<>(null, new Vertex<>(count, value));
        nodes.add(node);
    }

    @Override
    public void insertEdge(T start, T end, int weight) {
        for (Node<Vertex<T>> tmp:nodes) {
            if(start.equals(tmp.getValue().getValue())){
                while(tmp.getLeftChild()!=null){
                    tmp = tmp.getLeftChild();
                }
                tmp.setLeftChild(new Node<Vertex<T>>(weight,new Vertex<T>(end)));
                break;
            }
        }
    }

    @Override
    public void insertType(boolean type) {
        this.type=type;
    }

    @Override
    public List<Node<Vertex<T>>> getGraphLnk() {
        return this.nodes;
    }
    private Set<T> set= new HashSet<>();
    private Queue<T> queue = new LinkedList<>();
    private List<T> list = new ArrayList<>() ;
    @Override
    public List<T> graphBFS(List<Node<Vertex<T>>> graphLnk,T value) {

        queue.offer(value);
        set.add(value);
        while(!queue.isEmpty()){
            for (Node<Vertex<T>> tmp:graphLnk) {
                if(!queue.isEmpty()&&queue.peek().equals(tmp.getValue().getValue())){
                    tmp = tmp.getLeftChild();
                    while(tmp!=null){
                        if(set.add(tmp.getValue().getValue())){
                            queue.offer(tmp.getValue().getValue());
                        }
                        tmp=tmp.getLeftChild();
                    }
                    list.add(queue.poll());
                }
            }
        }
        for (Node<Vertex<T>> tmp:this.nodes) {
            if (set.add(tmp.getValue().getValue())){
                graphBFS(graphLnk,tmp.getValue().getValue());
            }
        }

        return list;
    }
}
