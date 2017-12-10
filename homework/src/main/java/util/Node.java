package util;

public class Node<T> {
    Node father;
    Node rightChild;
    Node leftChild;
    Integer key ;
    T value;
    public Node(){};

    public Node(Integer key) {
        this.key = key;
    }

    public Node(Integer key, T value) {
        this.key = key;
        this.value = value;
    }

    public Node(Integer key, Node father, Node rightChild, Node leftChild) {
        super();
        this.key = key;
        this.father = father;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

//    @Override
//    public String toString() {
//        return "Node{"+
//                "father{" + father +"}"+
//                ", rightChild=" + rightChild+
//                ", leftChild=" + leftChild+
//                ", key=" + key +
//                ", value=" + value +
//                '}';
//    }
}
