package sort;

import java.util.Random;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
       int[]orderArr = mergeSort(arr, 0, arr.length - 1);
    return orderArr;
    }

    private static int[] mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            int[] merge = merge(mergeSort(arr, begin, mid), mergeSort(arr, mid + 1, end));
            return merge;
        } else {
            return arr;
        }

    }

    private static int[] merge(int[] front, int[] last) {
        int i = 0;
        int n = 0;
        int m = 0;
        int[] meger = new int[front.length+last.length];
        while(n<front.length&&m<last.length){
            if(front[n]<=last[m]){
                meger[i]=front[n];
                n++;
            }else{
                meger[i]=last[m];
                m++;
            }
            i++;
        }
        if(n<front.length){
            for(;n<front.length;n++){
                
            }
        }
        return meger;
    }
    public static void main(String[] args) {
//        int[] arr = new int[100000];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = new Random().nextInt(1000000);
//            }
//        System.out.println(1);

      int[] arr = { 8, 5, 6, 7, 2, 3,10,8,3,4,2,0 };
        long startTime=System.currentTimeMillis();
        MergeSort.mergeSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        for ( int i : arr ) {
            System.out.println(i);
        }
    }
}
