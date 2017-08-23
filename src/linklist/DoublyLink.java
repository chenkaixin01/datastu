package linklist;


public class DoublyLink implements IList {

    private Node head;
    private Node end;
    private int size =0;
    @Override
    public Object search(Object key) {
        Node tmp = head;
        while (tmp != null) {
            if ((tmp.data == null && key == null) || tmp.data.equals(key)) {
                return tmp;
            } else {
                tmp = tmp.next;
            }
        }
        return null;        
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        boolean b = true;
        if (this.size == 0){
            b=false;
        }
        return b;
    }

    @Override
    public boolean contains(Object key) {
        boolean b=false;
        Node tem = head;
        while(tem!=null){
            if(tem.data == key){
                b = true;
            }
        }
        return b;
    }

    @Override
    public void add(Object e) {
        if(head == null){
            head = new Node(e);
        } else if(end == null){
            end = new Node(e);
            end.pre = head;
            head.next= end;
        } else{
            Node tem = new Node(e);
            tem.pre = end;
            end.next = tem;
            end = tem;
        }
        this.size++;
    }

    @Override
    public void remove(Object key) {
        Node tem = head;
        while(true){
            if(tem.data.equals(key)){
                delExcege(tem);
                System.out.println(tem.data);
                break;
            }
            tem = tem.next;
        }
    }


    @Override
    public int indexOf(Object e) {
        Node tem = head;
        int index = 0;
        while(tem != null){
            if(tem.data.equals(e)){
                return index;
            }
            tem=tem.next;
            index++;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        int i = 0;
        Node tem = head;
        if(index>0&&index<this.size){
            while(tem != null){
                if(i==index){
                    return tem.data;
                }
            }
        }
        
        return -1;
    }

    @Override
    public void add(Object e, int index) {
        Node newNode = new Node(e);
        Node tem = head;
        int i;
        if(0<index&&index<this.size){
            if(index < size/2){
                i=0;
                while(tem!=null){
                    if(i==index){
                        addExcege(newNode, tem);
                    }
                    tem=tem.next;
                    i++;
                }
            } else{
                while(tem!=null){
                    i = this.size;
                    if(i==index){
                        addExcege(newNode, tem);
                    }
                    tem=tem.pre;
                    i--;
                }
            }
            
        }
    }


    @Override
    public Object delete(int index) {
        Node tem = head;
        Object result = null;
        int i;
            if(0<index&&index<this.size){
                if(index < size/2){
                    i=0;
                    while(tem!=null){
                        if(i==index){
                            delExcege( tem);
                            result = tem.data;
                        }
                        tem=tem.next;
                        i++;
                    }
                } else{
                    while(tem!=null){
                        i = this.size;
                        if(i==index){
                            delExcege( tem);
                            result = tem.data;

                        }
                        tem=tem.pre;
                        i--;
                    }
                }
                
            }
        

        return result;
    }
    private void addExcege(Node newNode, Node tem) {
        newNode.next = tem.next.next;
        newNode.pre = tem.next.pre;
        tem.next = newNode;
        newNode.pre = tem;
    }
    private void delExcege(Node tem) {
        tem.pre.next = tem.next;
        tem.next.pre = tem.pre;
    }
    private class Node{
        Node next;
        Node pre;
        Object data;
        
        public Node(Object data){
            this.data = data;
            
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (data == null) {
                if (other.data != null)
                    return false;
            } else if (!data.equals(other.data))
                return false;
            return true;
        }

        private DoublyLink getOuterType() {
            return DoublyLink.this;
        }
        
        @Override
        public String toString(){
            return this.data.toString();  
        }
        
    }
    @Override
    public String toString() {
        Node e = head;
        StringBuilder sb = new StringBuilder("[");
        while (e != null) {
            sb.append(e.data.toString()).append(",");
            e = e.next;
        }
        sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        DoublyLink dl = new DoublyLink();
        dl.add(3);
        dl.add(9);
        dl.add(45);
        dl.add(56);
        dl.add(89);
        
     //   dl.remove(9);
        System.out.println(dl.toString());
    }

}

