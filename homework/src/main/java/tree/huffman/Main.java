package tree.huffman;

import com.sun.org.apache.xpath.internal.operations.Or;
import util.Node;
import util.Order;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int value;
        Random random = new Random ();
        Node<Integer>[] nodes = new Node[20];
        for (int i=0;i<20;i++){
            nodes[i] = new Node<Integer>();
        }
        for (int i=0;i<20;i++){
            value = random.nextInt (100);
            System.out.println ("输入："+value);
            nodes[i].setKey(value);
            nodes[i].setValue(value);
        }
        Huffman<Integer> huffman = new HuffmanImpl<>(nodes);
        Node<Integer> node = huffman.getHuffmanTree();
        List<Node> list = Order.inOrder(node);
        for (Node node1:list ) {
            System.out.println("key:"+node1.getKey()+"value:"+node1.getValue());
        }
    }
}
