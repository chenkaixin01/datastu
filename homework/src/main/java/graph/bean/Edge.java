package graph.bean;

import java.util.Objects;

public class Edge<T> {
    private Vertex<T> start;
    private Vertex<T> end;
    private int weight;

    public Edge(Vertex<T> start, Vertex<T> end) {
        this.start = start;
        this.end = end;
        weight = -1;
    }

    public Edge(Vertex<T> start, Vertex<T> end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        boolean b1 = (Objects.equals(start, edge.start) && Objects.equals(end, edge.end));
        boolean b2 = Objects.equals(start.getIndex(),edge.start.getIndex())&&
                Objects.equals(end.getIndex(),edge.end.getIndex());
        return weight == edge.weight && (b2||b1);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end, weight);
    }
}
