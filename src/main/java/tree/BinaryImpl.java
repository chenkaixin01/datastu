package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryImpl implements Binary {

    Node root = null;
    int size = 0;

    @Override
    public void add(Integer obj) {
        Node newNode = new Node(obj, null, null, null);
        if (this.root == null) {
            this.root = newNode;
            this.size++;
        } else {
            if (newNode.value > this.root.value) {
                birth(this.root.rightChild, newNode, this.root);
            } else {
                birth(this.root.leftChild, newNode, this.root);

            }

        }
    }

    private void birth(Node root, Node newNode, Node father) {
        if (root == null) {
            root = newNode;
            root.father = father;
            if (root.value > father.value) {
                father.rightChild = root;
            } else {
                father.leftChild = root;
            }
            this.size++;
        } else {
            Node tem = root;
            if (newNode.value > tem.value) {
                birth(tem.rightChild, newNode, root);

            } else {
                birth(tem.leftChild, newNode, root);

            }
        }
    }

    @Override
    public boolean remove(Integer e) {
        Node die =find(e);
        boolean b = false;
        boolean bLeft = die.leftChild == null;
        boolean bRight = die.rightChild == null;
        if(bLeft&&bRight){
            if(e<=die.father.value){
                die.father.leftChild = null;
                b = true;
            }else{
                die.father.rightChild = null;
                b = true;
            }
        }else if((!bLeft)&&(!bRight)){
            Node replace = max(die.leftChild);
            if(e>die.father.value){
                if(replace.value>replace.father.value){
                    replace.father.rightChild = null;
                }else{
                    replace.father.leftChild = null;
                }
                replace.father = die.father;
                die.rightChild.father = replace;
                replace.rightChild=die.rightChild;
                replace.leftChild=die.leftChild;
                die.father.rightChild = replace;
            }
//            replace.father.rightChild = null;
//            replace.father=die.father;
//            replace.leftChild = die.leftChild;
//            replace.rightChild = die.rightChild;
            b= true;
        }else if(!bLeft){
            if(e<=die.father.value){
                die.father.leftChild = die.leftChild;
                b = true;
            }else{
                die.father.rightChild = die.leftChild;
                b = true;
            }
        }else if(!bRight){
            if(e<=die.father.value){
                die.father.leftChild = die.rightChild;
                b= true;
            }else{
                die.father.rightChild = die.rightChild;
                b =true;
            }
        }
        return b;
    }

    private Node max(Node root) {
        if((root.rightChild == null) ){
            return root;
        }else{
            return max(root.rightChild);
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.root != null;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public int getHeight() {
        if (!isEmpty()) {
            return -1;
        } else {
            return height(this.root);
        }
    }

    private int height(Node root) {
        int rightHeight = 0;
        int leftHeight = 0;
        if (root.leftChild != null) {
            leftHeight = height(root.leftChild) + 1;
        }
        if (root.rightChild != null) {
            rightHeight = height(root.rightChild) + 1;
        }
        return rightHeight > leftHeight ? rightHeight : leftHeight;
    }

    @Override
    public Node find(Integer e) {
        if (this.root != null) {
            if (this.root.value == e) {
                return this.root;
            } else {
                if (e < this.root.value) {
                    return find(this.root.leftChild, e);
                } else {
                    return find(this.root.rightChild, e);
                }
            }
        }
        return null;

    }

    private Node find(Node root, Integer e) {
        if (root.value == e) {
            return root;
        } else {
            if (e < root.value) {
                return find(root.leftChild, e);
            } else {
                return find(root.rightChild, e);
            }
        }

    }

    @Override
    public List<Integer> preOrder() {
        List<Integer> list = new LinkedList<Integer>();
        return preOrder(this.root, list);
    }

    private List<Integer> preOrder(Node root, List<Integer> list) {
        list.add(root.value);
        if (root.leftChild != null) {
            preOrder(root.leftChild, list);
        }
        if (root.rightChild != null) {
            preOrder(root.rightChild, list);
        }
        return list;
    }

    @Override
    public List<Integer> inOrder() {
        List<Integer> list = new LinkedList<Integer>();
        return inOrder(this.root, list);
    }

    private List<Integer> inOrder(Node root, List<Integer> list) {
        if (root.leftChild != null) {
            inOrder(root.leftChild, list);
        }
        list.add(root.value);
        if (root.rightChild != null) {
            inOrder(root.rightChild, list);
        }
        return list;   
        }

    @Override
    public List<Integer> postOrder() {
        List<Integer> list = new LinkedList<Integer>();
        return postOrder(this.root, list);   
    }

    private List<Integer> postOrder(Node root, List<Integer> list) {
        if (root.leftChild != null) {
            postOrder(root.leftChild, list);
        }
        if (root.rightChild != null) {
            postOrder(root.rightChild, list);
        }
        list.add(root.value);
        return list;          
    }

    @Override
    public List<Integer> levelOrder() {
       
        return null;
    }
    

    public static void main(String[] args) {
        Binary binary = new BinaryImpl();
        binary.add(10);
        binary.add(5);
        binary.add(15);
        binary.add(3);
        binary.add(7);
        binary.add(2);
        binary.add(1);
        binary.add(4);
        binary.add(13);
        binary.add(18);
        binary.add(11);
        binary.add(14);
        binary.add(12);
        binary.add(20);
        binary.add(16);
        binary.add(19);
        binary.add(17);

        System.out.println(binary.find(16).value);
        System.out.println(binary.getSize());
        System.out.println(binary.getHeight());
        System.out.println(binary.isEmpty());
//        binary.remove(18);
        List list = binary.preOrder();
        System.out.println(list.toString());
        list =binary.inOrder();
        System.out.println(list.toString());
        list = binary.postOrder();
        System.out.println(list.toString());

    }

}
