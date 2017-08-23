package sort;

import java.util.Random;

public class BubbleSort {
    
    /**
     * 冒泡排序：用双重循环：外层循环控制遍历的次数，内层循环中比较相邻两个数，若前数比后数大，则交换位置
     * 百万数排序耗时27分钟
     * @param arr
     * @return
     */
    public static void bubbleSort(int[] arr) {
        
        for ( int i = 0; i < arr.length; i++ ) {

            for ( int j = 0; j < (arr.length - i - 1); j++ ) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            }
        }
        
    }
/**
 * 需要传入数组，直接传入int，不会改变，基本数据类型是值传递
 * @param arr
 * @param x
 * @param y
 */
    private static void swap(int[] arr, int x, int y) {
        int tem;
        tem = arr[x];
        arr[x] = arr[y];
        arr[y] = tem;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(1000000);
            }
        System.out.println(1);
//        int[] arr = { 8, 5, 6, 7, 2, 3 };
//        int[] arr1 = 
        long startTime=System.currentTimeMillis();
            BubbleSort.bubbleSort(arr);
            long endTime=System.currentTimeMillis(); 
            System.out.println(endTime-startTime);
        }
}
