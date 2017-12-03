package seqlist.list;

import seqlist.list.SeqList;

public class SeqListImpl<T> implements SeqList<T> {
    private T[] data = null;
    private int size;
    private int length = 0;
    private SeqListImpl() {
    }

    /**
     * 通过构造函数创建数组来存储顺序表的数据
     *
     * @param size
     */
    public SeqListImpl(int size) {
        this.size = size;
        this.data = (T[]) new Object[this.size];
    }

    public T[] enptyList() {
        this.data = null; // 直接将数组置换为null；第一次试下，理论上应该可以
        return this.data;
    }

    public void add(T t) {
        if(this.length<this.size){
            this.data[this.length] = t; // 顺序表的初始长度为0；当加入一个元素是长度+1
            this.length++;
        }else{
            System.out.println("表已满");
        }
    }

    public T[] insertData(int i, T t) {
        if(this.length<this.size){
            int j = this.length;
            while(j>i){
                this.data[j] = this.data[j-1];
                j--;
            }
            this.data [i] = t;
            this.length ++;
        }else{
            System.out.println("表已满");
        }

        return this.data;
    }

    public T deleteData(int i) {
        T obj = null ;

        if(this.length != 0){
            if(0 <= i && i<this.length){
                obj = this.data[i];
                for ( ; i < data.length-1; i++ ) {
                    this.data[i] = this.data[i+1];
                }
                this.data[this.length-1] = null;
                this.length--;
            }else {
                System.out.println("该元素不在范围内");
            }
        } else {
            System.out.println("顺序表为空");
        }
        return obj;
    }

    public T[] selectAll() {
        return this.data;
    }

    public T selectData(int i) {
        return this.data[i];
    }

    public int selectIndex(T t) {
        for(int i=0;i<this.length;i++){
            if(this.data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T replaceData(int i, T obj) {
        T rep ;
        if(this.length != 0){
            if(0 <= i && i<this.length-1){
                rep = this.data[i];
                this.data[i] = obj;
                return rep;
            }else {
                System.out.println("该元素不在范围内");
            }
        } else {
            System.out.println("顺序表为空");
        }
        return null;
    }

    public int lenthList() {
        return this.length;
    }
}
