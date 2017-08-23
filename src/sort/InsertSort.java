package sort;

import java.util.Random;

public class InsertSort {
    /**
     * 插入排序：将一个数再已经有序的序列中找到自己的位子插入，在数组中选择有序序列的后一个数，并在有序部分从后往前遍历对比
     * 百万随机数排序耗时：523569毫秒；约9分钟；
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for ( int i = 1; i < arr.length; i++ ) {
            for ( int j = i; j > 0; j-- ) {
                if (arr[j] >= arr[j - 1]) {
                    break;
                }
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        // TODO Auto-generated method stub
        int tem;
        tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args) {
//        int[] arr = new int[1000000];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = new Random().nextInt(1000000);
//            }
        int[] arr = {8,5,6,7,2,3};
        long startTime=System.currentTimeMillis();
        InsertSort.insertSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);

        for ( int i : arr ) {
            System.out.println(i);
        }
    }
}
