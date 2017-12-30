package graph.bean;

import java.util.Objects;

public class Vertex<T> {
    private int index;
    private T value;

    public Vertex(T value) {
        this.value = value;
    }

    public Vertex(int index, T value) {
        this.index = index;
        this.value = value;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return getIndex() == vertex.getIndex() ||
                Objects.equals(getValue(), vertex.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIndex(), getValue());
    }
}

