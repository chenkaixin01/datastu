package tree.huffman;

import tree.heap.MinHeap;
import tree.heap.MinHeapImpl;
import util.Node;

import java.util.Arrays;

import static java.util.Arrays.copyOf;


public class HuffmanImpl<T> implements Huffman<T> {
    private Node<T>[] forest;
    private int size;
    private int length;

    public HuffmanImpl() {
        this.forest = new Node[16];
        this.size = forest.length;
        this.length = 0;
    }

    public HuffmanImpl(Node<T>[] forest) {
        this.forest = forest;
        this.size = forest.length;
        this.length = forest.length;
    }

    public void putForest(int key, T value) {
      if (this.length>=0.75*this.size){
          this.forest= copyOf(forest,this.size+16);
          this.size=this.size+16;
      }
      Node<T> newNode = new Node<T>(key,value);
      this.forest[this.length] = newNode;
      this.length++;
    }


    public Node<T> getHuffmanTree() {
        if(this.length<=0){
            return null;
        }
       MinHeap<T> minHeap = new MinHeapImpl<>(this.forest,this.length);
        Node<T> first;
        Node<T> second;
        while(this.length>1){
            first = minHeap.popTopEntry();
            second = minHeap.popTopEntry();
            Node<T> newNode = new Node<T>();

            first.setFather(newNode);
            second.setFather(newNode);
            newNode.setLeftChild(first);
            newNode.setRightChild(second);
            newNode.setKey(first.getKey()+second.getKey());
            minHeap.insert(newNode);
            this.length--;
        }
        return forest[0];
    }
}
