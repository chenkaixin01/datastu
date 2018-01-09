package sort;

import java.util.Random;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
       int[] orderArr = mergeSort(arr, 0, arr.length - 1);
    return orderArr;
    }

    private static int[] mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            int[] merge = merge(mergeSort(arr, begin, mid), mergeSort(arr, mid + 1, end));
            return merge;
        } else {
            int[] tmp = new int[1];
            tmp[0] = arr[begin];
            return tmp;
        }

    }

    private static int[] merge(int[] front, int[] last) {
        int i = 0;
        int n = 0;
        int m = 0;
        int[] meger = new int[front.length+last.length];
//        System.out.println(front.length+last.length);
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
                meger[i]=front[n];
                i++;
            }
        }
        if(m<last.length){
            for (;m<last.length;m++) {
                meger[i]=last[m];
                i++;
            }
        }
        return meger;
    }
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(100000000);
            }

//      int[] arr = { 8, 5, 6, 7, 2, 3, 9, 3, 4, 1, 0, 9};
        long startTime=System.currentTimeMillis();

        int[] result = MergeSort.mergeSort(arr);
        System.out.printf("取前十位数:");
        for (int i = 0; i < 10; i++) {
            System.out.printf(result[i] + " ");
        }
        long endTime=System.currentTimeMillis();
        System.out.printf("时间" +":"+ (endTime-startTime));
//        for ( int i : result ) {
//            System.out.println(i);
//        }
    }
}
