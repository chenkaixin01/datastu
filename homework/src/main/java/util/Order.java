package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的遍历，前序，中序，后序，层次
 */
public class Order {
    public static List<Node> preOrder(Node node) {
        List<Node> list = new ArrayList<>();
        return preOrder(node,list);
    }

    private static List<Node> preOrder(Node root,List<Node> list) {
        list.add(root);
        if (root.getLeftChild() != null) {
            preOrder(root.getLeftChild(), list);
        }
        if (root.getRightChild() != null) {
            preOrder(root.getRightChild(), list);
        }
        return list;
    }

    public static List<Node> inOrder(Node node) {
        List<Node> list = new LinkedList<>();
        return inOrder(node, list);
    }

    private static List<Node> inOrder(Node root, List<Node> list) {
        if (root.getLeftChild() != null) {
            inOrder(root.getLeftChild(), list);
        }
        list.add(root);
        if (root.getRightChild() != null) {
            inOrder(root.getRightChild(), list);
        }
        return list;
    }

    private static List<Node> postOrder(Node root, List<Node> list) {
        if (root.getLeftChild() != null) {
            postOrder(root.getLeftChild(), list);
        }
        if (root.getRightChild() != null) {
            postOrder(root.getRightChild(), list);
        }
        list.add(root);
        return list;
    }

    public static List<Node> levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        Node tmp;
        if(node==null){
            return null;
        }
        queue.offer(node);
        while(queue.peek()!=null){
            tmp = queue.poll();
            if(tmp.getLeftChild()!=null){
                queue.offer(tmp.getLeftChild());
            }
            if(tmp.getRightChild()!=null){
                queue.offer(tmp.getRightChild());
            }
            list.add(tmp);
        }
        return list;
    }

}
