package queue.myqueue;

public class LinkQueue<T> {
    Node<T> front;
    Node<T> rear;
    int size = 0;


    /**
     * 返回队列的长度
     * @return 队列的长度
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 判断队列是否为空
     * @return 队头为空，队列就空
     */
    public boolean isEmpty(){
        return front==null;
    }

    /**
     * 入队：
     * 如果队头为空则队头和队尾指向新节点
     * 如果队头与队尾指向同一元素则队尾指向新元素，队头指针指向队尾
     * 除了以上情况，新元素都直接加在队尾之后
     * @param value：存储的值
     * @return 返回插入状态
     */
    public boolean enQueue(T value){
        Node<T> newNode = new Node<T>(value);
        if(front==null){
            front = newNode;
            rear = front;
            this.size++;
            return true;
        }else if(rear==front){
            rear = newNode;
            front.next=rear;
            this.size++;
            return true;
        }else{
            Node<T> tem = rear;
            tem.next=newNode;
            rear = newNode;
            this.size++;
            return true;
        }

    }

    /**
     * 出队：
     * 当头结点空时为空
     * 出队，并删除该节点
     * @return
     */
    public T deQueue(){
        Node<T> tem = front;
        if(front==null){
            return null;
        }
        if(rear==front){
            rear=null;
            front=null;
            this.size--;
            return tem.value;
        }
        front = tem.next;
        this.size--;
        return tem.value;
    }

    /**
     * 取队头，但不删除
     * @return
     */
    public Node<T> peek(){
        if(front==null){
            return null;
        }
        return front;
    }

}
