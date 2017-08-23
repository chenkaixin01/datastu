package sort;

import java.util.Random;

public class HeapSort {
    /**
     * 堆排序：一、构建大顶堆/小顶堆{若只有一个元素则自动构成顶堆}；从n/2-1开始修复；
     *         将节点与较小的子节点对比，如果比子节点大，则子节点上浮，重复直到递归到堆顶修复完成后，堆就构成了；
     *      二、将堆顶与无序区的最后交换
     *      三、接着修复
     * @param arr
     */
    public static void heapSort(int[] arr) {
        makeMinHeap(arr);
        for ( int i = arr.length - 1; i >= 1; i-- ) {
            swap(arr, i, 0);
            minHeapFixDown(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    private static void makeMinHeap(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return;
        }
        for ( int i = n / 2 - 1; i >= 0; i-- ) {
            minHeapFixDown(arr, i, n);
        }
    }

    private static void minHeapFixDown(int[] arr, int index, int length) {
        int j = 2 * index + 1;
        int temp = arr[index];
        while (j < length) {
            if ((j + 1) < length && arr[j + 1] < arr[j]) {
                j++;
            }
            if (temp > arr[j]) {
                arr[index] = arr[j];
                index = j;
                j = 2 * index + 1;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for ( int i = 0; i < arr.length; i++ ) {
        arr[i] = new Random().nextInt(100000000);
        }
        System.out.println(1);
//      int[] arr = { 123, 1, 8, 28, 46, 36, 27 };
      long startTime = System.currentTimeMillis();
      HeapSort.heapSort(arr);
      long endTime = System.currentTimeMillis();
      System.out.println(endTime - startTime);
//      for ( int i : arr ) {
//          System.out.println(i);
//      }
    }

}