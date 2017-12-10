package tree.heap;

import util.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapImpl<T> implements MinHeap<T> {
    private Node[] heap ;
    private int length = 0;
    private int size;

    /**
     *默认初始化堆的容量为10
     */
    public MinHeapImpl(){
        this.size = 10;
        this.heap = new Node[size];
    }

    /**
     * 传入一个实体数组，初始化堆，堆的大小为数组的大小
     * @param heap:传入的数组
     */
    public MinHeapImpl(Node<T>[] heap,int length) {
        this.heap = heap;
        this.size = heap.length;
        this.length = length;
        makeMinHeap(this.heap);
    }

    /**
     * 根据输入值初始化堆
     * @param size 堆的容量
     */
    public MinHeapImpl(int size) {
        this.size = size;
        this.heap = new Node[size];
    }

    /**
     * 插入堆元素
     *     当堆为空是直接插入
     *     当堆不为空且未满是在末尾加入元素，然后构建堆
     *     当堆满时，如果value大于堆顶则替换堆顶重新构建堆
     * @param key 键/权值
     * @param value 值
     * @return 返回插入状态
     */
    public boolean insert(int key,T value) {
        Node<T> newNode = new Node<T>(key,value);
        if (insert(newNode)) return true;
        return false;
    }

    public boolean insert(Node<T> newNode) {
        if(this.length==0){
            heap[this.length] = newNode;
            this.length++;
            return true;
        }
        if (this.length<this.size){
            heap[this.length] = newNode;
            this.length++;
            makeMinHeap(this.heap);
            return true;
        }
        if (this.length>=size){
            if (newNode.getKey ()>heap[0].getKey ()){
                heap[0]=newNode;
                makeMinHeap (this.heap);
                return true;
            }else {
                System.out.println ("该值不在前"+this.size+"位之内");
            }
        }
        return false;
    }

    /**
     * 构建堆
     * @param heap 待构建的堆
     */
    private void makeMinHeap(Node<T>[] heap) {
        if (this.length<=1){
            return;
        }
        int last = this.length;
        for (int i=last/2-1;i>=0;i--){
            adjustMinHeap(this.heap,i,last);
        }
    }

    /**
     * 调整堆内的位置使达到最小堆的形式
     *     循环内，取左右节点中小的那个进行比较
     * @param heap 待调整的堆
     * @param index 索引
     * @param last 堆的最后一个元素的索引
     */
    private void adjustMinHeap(Node<T>[] heap, int index, int last) {
        int sonIndex = index*2+1;
        Node<T> tmp = heap[index];
        while(sonIndex<last){
            if((sonIndex+1<last)&&heap[sonIndex+1].getKey ()<heap[sonIndex].getKey ()){
                sonIndex++;
            }
            if (tmp.getKey ()>heap[sonIndex].getKey ()){
                heap[index]=heap[sonIndex];
                index = sonIndex;
                sonIndex = index*2+1;
            }else {
                break;
            }
        }
        heap[index] = tmp;
    }

    public boolean removeByKey(int key) {
        for (int i=0;i<this.length;i++){
            if (heap[i].getKey () == key){
                heap[i]=heap[this.length-1];
                heap[this.length-1] = null;
                this.length--;
                makeMinHeap (heap);
                return true;
            }
        }
        return false;
    }

    public List<T> getValueByKey(int key) {
        List<Node<T>> listEntry = getEntryByKey (key);
        List<T> list = new ArrayList<T> (listEntry.size ());
        for (Node<T> tmpNode:listEntry){
            list.add (tmpNode.getValue ());
        }
        return list;
    }

    public List<Node<T>> getEntryByKey(int key) {
        Node<T> tmpNode;
        List<Node<T>> list = new ArrayList<Node<T>> ();
        for (int i=0; i<this.length; i++){
            if(this.heap[i].getKey () == key){
                list.add (this.heap[i]);
            }
        }
        return list;
    }

    public T popTopValue() {
        return popTopEntry().getValue ();
    }

    public Node<T> popTopEntry() {
        if(this.length==0){
            return null;
        }
        Node<T> tmpNode = this.heap[0];
        this.heap[0]= this.heap[this.length-1];
        this.heap[this.length-1] = null;
        this.length--;
        makeMinHeap (this.heap);
        return tmpNode;
    }

    public T getTopVlue() {
        return getTopEntry().getValue ();
    }

    public Node<T> getTopEntry() {
        if(this.length==0){
            return null;
        }
        return this.heap[0];
    }

    public boolean isEmpty() {
        return this.length!=0;
    }

    public int getLength() {
        return length;
    }

    public List<T> selectAll() {
        List<T> list = new ArrayList<T> (heap.length);
        for (int i=0 ;i<this.size; i++){
            list.add (popTopValue ());
        }
        return  list;
    }
}
