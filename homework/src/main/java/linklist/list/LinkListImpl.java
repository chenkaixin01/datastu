package linklist.list;
import java.util.LinkedList;
import java.util.List;
public class LinkListImpl<T> implements LinkList<T> {
    /**
     * 定义头节点
     */
    Node<T> head = null;
    int length = 0;
    boolean b = false;


    public boolean add(T data) {
        Node<T> newNode = new Node<T>(data);
        // 判断头节点是否为空
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tem = head;
            while (tem.next != null) {
                tem = tem.next;
            }
            tem.next = newNode;
        }
        this.length++;
        return true;
    }


    public boolean delete(int index) {
        Node<T> tem = head;
        int i = 0;
        if (index == 0) {
            head = tem.next;
            this.length--;
            return true;
        } else {
            while (tem.next != null) {
                i++;
                if (index == i) {
                    tem.next = tem.next.next;
                    this.length--;
                    return true;
                }
                tem = tem.next;
            }
        }
        return false;
    }


    public boolean insert(int index, T data) {
        Node<T> tem = head;
        Node<T> newNode = new Node<T>(data);
        int i = 0;

        while (tem.next != null) {
            if (index == i) {
                newNode.next = tem.next;
                tem.next = newNode;
                this.length++;
                return true;
            }
            tem = tem.next;
            i++;
        }

        return false;
    }

    public List<T> selectAll() {
        Node<T> tem = head;
        List<T> list = new LinkedList<T>();
        while (tem != null) {
            list.add(tem.data);
            System.out.println(tem.data.toString());
            tem = tem.next;
        }
        return list;
    }

    public T selectIndex(int index) {
        int i = 0;
        Node<T> tem = head;
        if(index>=0&&index<this.length){
            while(tem!=null){
                if(i==index){
                    System.out.println(tem.data.toString());
                    return tem.data;
                }
                tem=tem.next;
            }
        }
        return null;
    }

    public int length() {
        System.out.println(this.length);
        return this.length;
    }
}
