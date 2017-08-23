package linklist;
/**
 * 
 * @author chenkaixin
 *
 */
public class Node {
    public Node next;  //叶子里包着下一片叶子或者没有
    public int data;
    
    public Node(int data){   //写在叶子里的数据
        this.data = data;
    }
    
    public void thisData(){
        System.out.println(this.data);
    }
}
