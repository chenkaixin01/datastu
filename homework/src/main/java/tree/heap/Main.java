package tree.heap;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeapImpl<Integer>(20);
        System.out.println ("------------------插入-----------------");
        int value;
        Random random = new Random ();
        for (int i=0;i<100;i++){
            value = random.nextInt (100);
            System.out.println ("输入："+value);
            heap.insert (value,value);
            System.out.println (heap.getLength ());
        }
        for (int i = 0;i<20;i++) {
            System.out.printf (heap.popTopValue ().toString ());
            System.out.printf ("\n");
        }
//        List<Integer> list= heap.selectAll ();
//        for (Integer val:list){
//            System.out.println (val);
//        }
    }
}
