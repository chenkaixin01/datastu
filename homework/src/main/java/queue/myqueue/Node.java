package queue.myqueue;

public class Node<T> {
    protected Node<T> next;
    protected T value;
    private Node<T> father;
    private int label;
    public Node(T value){
        this.value=value;
    }
    public Node(Node<T> next, T value) {
        super();
        this.next = next;
        this.value = value;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getFather() {
        return father;
    }

    public void setFather(Node<T> father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        if (next != null ? !next.equals(node.next) : node.next != null) return false;
        if (value != null ? !value.equals(node.value) : node.value != null) return false;
        return father != null ? father.equals(node.father) : node.father == null;
    }

    @Override
    public int hashCode() {
        int result = next != null ? next.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (father != null ? father.hashCode() : 0);
        return result;
    }
}
