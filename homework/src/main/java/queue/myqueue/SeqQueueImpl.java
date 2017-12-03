package queue.myqueue;

import java.util.ArrayList;
import java.util.List;

public class SeqQueueImpl<T> implements SeqQueue<T> {
    private Object[] queue;
    private int size;
    private int length = 0;

    public SeqQueueImpl(int size) {
        queue = new Object[size];
        this.size = size;
    }

    public boolean isEmpty(){
        return queue == null || queue[0]==null;
    }
    public boolean isFill() {
        return this.length>=this.size;
    }

    public boolean enQueue(T value) {
        if(isFill()){
            System.out.println("队列已满");
            return false;
        }
        queue[this.length] = value;
        this.length++;
        return true;
    }

    public T deQueue() {
        T tem = (T)queue[0];
        for (int i = 1; i < this.length; i++) {
            queue[i-1] = queue[i];
        }
        return tem;
    }

    public T peep() {
        return (T)queue[0];
    }

    public List<T> deQueueAll() {
        List<T> list = new ArrayList<T>(this.length);
        for (int i = 0; i < this.length; i++) {
            list.add((T)queue[i]);
            queue[i]=null;
        }
        return list;
    }

    public List<T> selectAll() {
        List<T> list = new ArrayList<T>(this.length);
        for (int i = 0; i < this.length; i++) {
            list.add((T)queue[i]);
        }
        return list;
    }

    public int length() {
        return this.length;
    }
}
