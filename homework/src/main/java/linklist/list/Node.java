package linklist.list;

public class Node<T> {
    public Node<T> next;  //叶子里包着下一片叶子或者没有
    public T data;

    public Node(T data){   //写在叶子里的数据
        this.data = data;
    }

    public void thisData(){
        System.out.println(this.data);
    }
}
