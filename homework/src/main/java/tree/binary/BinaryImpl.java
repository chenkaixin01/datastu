package tree.binary;

import util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryImpl implements Binary {
    private Node root = null;
    private int size = 0;
    public void add(Integer key) {
        Node newNode = new Node(key);
        //  如果根节点为null则新节点直接作为根节点，否则正常插入
        if (this.root == null) {
            this.root = newNode;
            this.size++;
        } else {
            if (newNode.getKey () > this.root.getKey ()) {
                birth(this.root.getRightChild (), newNode, this.root);
            } else {
                birth(this.root.getLeftChild(), newNode, this.root);

            }

        }
    }

    public boolean remove(Integer key) {
        Node toDel =findByKey(key);
        if(toDel==null){
            return false;
        }
        boolean bLeft = toDel.getLeftChild() == null;
        boolean bRight = toDel.getRightChild () == null;
//        如果这个节点是叶子节点，也就是左右节点都为null则直接删除此节点
        if(bLeft&&bRight){
//            确定是父节点的左子或右子，并删除
            if(key<=toDel.getFather ().getKey ()){
                toDel.getFather ().setLeftChild (null);
            }else{
                toDel.getFather ().setRightChild (null);
            }
//            如果左右节点都不为null，则取左节点的最大的节点替代被删节点
        }else if((!bLeft)&&(!bRight)){
            Node replace = max(toDel.getLeftChild());
            if(key>toDel.getFather ().getKey ()){
                if(replace.getKey ()>replace.getFather ().getKey ()){
                    replace.getFather().setRightChild(null);
                }else{
                    replace.getFather().setLeftChild(null);
                }
                replace.setFather(toDel.getFather());
                toDel.getRightChild().setFather(replace);
                replace.setRightChild(toDel.getRightChild());
                replace.setLeftChild(toDel.getLeftChild());
                toDel.getFather().setRightChild(replace);
            }
//            如果有左节点,左节点代替被删节点
        }else if(!bLeft){
            if(key<=toDel.getFather().getKey ()){
                toDel.getFather().setLeftChild(toDel.getLeftChild());
            }else{
                toDel.getFather().setRightChild(toDel.getLeftChild());
            }
        }else {
            if(key<=toDel.getFather().getKey ()){
                toDel.getFather().setLeftChild(toDel.getLeftChild ());
            }else{
                toDel.getFather().setRightChild(toDel.getRightChild());
            }
        }
        return true;
    }
    private Node max(Node root) {
        if((root.getRightChild() == null) ){
            return root;
        }else{
            return max(root.getRightChild());
        }
    }
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.root != null;
    }

    public Node getRoot() {
        return this.root;
    }

    public int getHeight() {
        if (!isEmpty()) {
            return -1;
        } else {
            return height(this.root);
        }
    }

    /**
     * 以根节点为起点，向下遍历左右子树，增加一层就加一，最终比较左右子树，大的加一为数的深度
     * @param root 根节点
     * @return 返回树高
     */
    private int height(Node root) {
        int rightHeight = 0;
        int leftHeight = 0;
        if (root.getLeftChild() != null) {
            leftHeight = height(root.getLeftChild()) + 1;
        }
        if (root.getRightChild() != null) {
            rightHeight = height(root.getRightChild()) + 1;
        }
        return rightHeight > leftHeight ? rightHeight : leftHeight;
    }
    public Node findByKey(Integer key) {
        if (this.root != null) {
            if (key.equals (this.root.getKey ())) {
                return this.root;
            } else {
                if (key < this.root.getKey ()) {
                    return findByKey(this.root.getLeftChild(), key);
                } else {
                    return findByKey(this.root.getRightChild(), key);
                }
            }
        }
        return null;
    }
    private Node findByKey(Node root, Integer key) {
        if (key.equals (root.getKey ())) {
            return root;
        } else {
            if (key < root.getKey ()&&root.getLeftChild()!=null) {
                return findByKey(root.getLeftChild(), key);
            } else if(root.getRightChild()!=null){
                return findByKey(root.getRightChild(), key);
            }else {
                return null;
            }
        }

    }
    public List<Integer> preOrder() {
        List<Integer> list = new LinkedList<>();
        return preOrder(this.root, list);
    }

    private List<Integer> preOrder(Node root, List<Integer> list) {
        list.add(root.getKey ());
        if (root.getLeftChild() != null) {
            preOrder(root.getLeftChild(), list);
        }
        if (root.getRightChild() != null) {
            preOrder(root.getRightChild(), list);
        }
        return list;
    }
    public List<Integer> inOrder() {
        List<Integer> list = new LinkedList<>();
        return inOrder(this.root, list);
    }
    private List<Integer> inOrder(Node root, List<Integer> list) {
        if (root.getLeftChild() != null) {
            inOrder(root.getLeftChild(), list);
        }
        list.add(root.getKey ());
        if (root.getRightChild() != null) {
            inOrder(root.getRightChild(), list);
        }
        return list;
    }
    public List<Integer> postOrder() {
        List<Integer> list = new LinkedList<>();
        return postOrder(this.root, list);
    }
    private List<Integer> postOrder(Node root, List<Integer> list) {
        if (root.getLeftChild() != null) {
            postOrder(root.getLeftChild(), list);
        }
        if (root.getRightChild() != null) {
            postOrder(root.getRightChild(), list);
        }
        list.add(root.getKey ());
        return list;
    }
    public List<Integer> levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        Node tmp;
        if(this.root==null){
            return null;
        }
        queue.offer(this.root);
        while(queue.peek()!=null){
            tmp = queue.poll();
            if(tmp.getLeftChild()!=null){
                queue.offer(tmp.getLeftChild());
            }
            if(tmp.getRightChild()!=null){
                queue.offer(tmp.getRightChild());
            }
            list.add(tmp.getKey ());
        }
        return list;
    }
    private void birth(Node root, Node newNode, Node father) {
        if (root == null) {
            root = newNode;
            root.setFather (father);
            if (root.getKey () > father.getKey ()) {
                father.setRightChild(root);
            } else {
                father.setLeftChild(root);
            }
            this.size++;
        } else {
            Node tem;
            tem = root;
            if (newNode.getKey() > tem.getKey ()) {
                birth(tem.getRightChild(), newNode, root);

            } else {
                birth(tem.getLeftChild(), newNode, root);

            }
        }
    }
}
