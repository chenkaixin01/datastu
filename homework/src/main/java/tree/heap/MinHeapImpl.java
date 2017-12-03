package tree.heap;

import java.util.Arrays;
import java.util.List;

public class MinHeapImpl implements MinHeap {
    private Integer[] heap ;
    private int length = 0;
    private int size;

    /**
     *默认初始化堆的容量为10
     */
    public MinHeapImpl(){
        this.size = 10;
        this.heap = new Integer[size];
    }

    /**
     * 根据输入值初始化堆
     * @param size 堆的容量
     */
    public MinHeapImpl(int size) {
        this.size = size;
        this.heap = new Integer[size];
    }

    /**
     * 插入堆元素
     *     当堆为空是直接插入
     *     当堆不为空且未满是在末尾加入元素，然后构建堆
     *     当堆满时，如果value大于堆顶则替换堆顶重新构建堆
     * @param value 值
     * @return 返回插入状态
     */
    public boolean insert(int value) {
        if(this.length==0){
            heap[this.length] = value;
            this.length++;
            return true;
        }
        if (this.length<this.size){
            heap[this.length] = value;
            this.length++;
            makeMinHeap(this.heap);
            return true;
        }
        if (this.length>=size){
            if (value>heap[0]){
                heap[0]=value;
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
    private void makeMinHeap(Integer[] heap) {
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
    private void adjustMinHeap(Integer[] heap, int index, int last) {
        int sonIndex = index*2+1;
        int tmp = heap[index];
        while(sonIndex<last){
            if((sonIndex+1<last)&&heap[sonIndex+1]<heap[sonIndex]){
                sonIndex++;
            }
            if (tmp>heap[sonIndex]){
                heap[index]=heap[sonIndex];
                index = sonIndex;
                sonIndex = index*2+1;
            }else {
                break;
            }
        }
        heap[index] = tmp;
    }

    public boolean remove(int value) {
        for (int i=0;i<this.length;i++){
            if (heap[i] == value){
                heap[i]=heap[this.length-1];
                heap[this.length-1] = null;
                this.length--;
                makeMinHeap (heap);
                return true;
            }
        }
        return false;
    }

    public boolean removeMin() {
        if(this.length==0){
            return false;
        }
        System.out.println (heap[0]);
        heap[0]= heap[this.length-1];
        heap[this.length-1] = null;
        this.length--;
        makeMinHeap (this.heap);
        return true;
    }

    public boolean isEmpty() {
        return this.length!=0;
    }

    public int getLength() {
        return length;
    }

    public int selectByKey(int key) {
        for (int i :heap){
            if (key==i){
                return i;
            }
        }
        return -1;
    }

    public List<Integer> selectAll() {
        return Arrays.asList (heap);
    }
}
