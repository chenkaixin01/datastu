package tree.heap;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeapImpl(20);
        System.out.println ("------------------插入-----------------");
        int value;
        Random random = new Random ();
        for (int i=0;i<100;i++){
            value = random.nextInt (100);
            System.out.println ("输入："+value);
            heap.insert (value);
            System.out.println (heap.getLength ());
        }
        for (int i = 0;i<20;i++) {
            heap.removeMin ();

        }
//        List<Integer> list= heap.selectAll ();
//        for (Integer val:list){
//            System.out.println (val);
//        }
    }
}
