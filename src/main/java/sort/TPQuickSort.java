package sort;

import java.util.Random;

public class TPQuickSort {
    /**
     * 双指针快速排序;通过头指针与尾指针同时前进，找到比分界值@pivot大或者小的值进行交换；
     * 千万级随机数耗时1608毫秒
     * @param arr
     * @param pivot
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pos = partition(arr, begin, end);
            quickSort(arr, begin, pos - 1);
            quickSort(arr, pos + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        while (begin < end) {
            /*
             * 从后往前遍历，找到比pivot小的值
             */
            while (begin < end && arr[end] >= pivot) {
                end--;
            }
            arr[begin] = arr[end];
            /*
             * 从前往后遍历，找到比pivot大的值；
             */
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = pivot;
        return begin;
    }

    public static void main(String[] args) {
//        int[] arr = { 8, 5, 6, 7, 2, 3 };
      int[] arr = new int[10000000];
      for(int i = 0; i < arr.length; i++){
          arr[i] = new Random().nextInt(10000000);
          }
        long startTime = System.currentTimeMillis();
        TPQuickSort.quickSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("时间" + ":" + (endTime - startTime));

//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }
}
