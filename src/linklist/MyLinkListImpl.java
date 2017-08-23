package linklist;
/**
 * 
 * @author chenkaixin
 *
 */
public class MyLinkListImpl implements MyLinkList {
    /**
     * 定义头节点
     */
    Node head = null;
    int length = 0;
    boolean b = false;
    

    @Override
    public void add(int data) {
       Node newNode = new Node(data);
       //判断头节点是否为空
       if(head == null){
           head = newNode;
       }else{
           Node tem = head;
           while(tem.next != null){
               tem = tem.next;
           }
           tem.next = newNode;
       }
       this.length++;

    }

    @Override
    public boolean delete(int index) {
        Node tem = head;
        if(index == 0){
            head = tem.next;
            return true;
        }else{
            int i = 1;
            while(tem.next != null){
                                             //因为i的初值为1，所以定位的值是要删除的值的前驱
                if(i==index){
                    Node deleTem = tem.next;
                    tem.next =deleTem.next;  //
                    b = true;
                    break;
                }
                tem = tem.next;
                i++;
            }
        }
        if(b){
            this.length--;
        }
        return b;
    }

    @Override
    public boolean insert(int index, int data) {
        b= false;
        Node tem = head;
        Node newNode = new Node(data);
        int i = 0;
        while(tem.next != null){
            if(i==index){
                newNode.next=tem.next;
                tem.next=newNode;
                b=true;
                break;
            }
            tem = tem.next;
            i++;
        }
        
        if(b){
            this.length++;
        }
        return b;
    }

    @Override
    public void selectAll() {
        Node tem = head;
        System.out.println(tem.data);
        while(tem.next !=null){
            System.out.println(tem.next.data);
            tem = tem.next;
        }
    }

    @Override
    public void selectIndex(int index) {
        Node tem = head;
        int i = 1;
        if(index == 0){
            System.out.println(head.data);
        return;
        }
        while(tem.next !=null){
            if(i==index){
                System.out.println(tem.next.data);
                return;
            }
            tem = tem.next;
            i++;
        }
    }
    
    @Override
    public void length() {
        System.out.println(this.length);
    }
    
    public static void main(String[] args) {
        MyLinkList my = new MyLinkListImpl();
        my.add(44);
        my.add(33);
        my.add(88);
        my.add(66);
        my.add(100);
        my.add(678);
        my.selectAll();
        my.length();
        System.out.println("=====================================");
        my.insert(3, 103);
        my.selectAll();
        my.length();
        System.out.println("++++++++++++++++++");
        my.delete(3);
        my.selectAll();
        my.length();
    //    my.selectIndex(4);
    }


}
