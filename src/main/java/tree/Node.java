package tree;

public class Node {
    Node father;
    Node rightChild;
    Node leftChild;
    Integer value ;
    public Node(){};
    
    public Node(Integer value,Node father, Node rightChild, Node leftChild) {
        super();
        this.value = value;
        this.father = father;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }

    @Override
    public String toString() {
        return "Node [root=" + father + ", rightChild=" + rightChild
                + ", leftChild=" + leftChild + "]";
    }
    
}
