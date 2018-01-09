package sort;

import java.util.Random;

public class CountSort {
    /**
     * 计数排序：建一个数组，以原数组的值对应新建数组的坐标，新数组的值代表新数组坐标对应的原数组的值出现的次数
     *        新建数组的大小以原数组max值+1为容量
     *        遍历一遍原数组，将对应信息存入新建数组
     *        遍历一遍新数组，将对应信息转为有序的数组存入原数组
     * 一亿以内的一亿个随机数排序耗时 3895毫秒；
     * 计数排序适合数据规模较小，数据值较小的排序，计数排序以空间换时间，当规模太大时空间就不够了
     * @param arr
     */
    public static void countSort(int[] arr) {
        int max = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        
        
        int[] count = new int[max + 1];
        for ( int i : arr ) {
            count[i]++;
        }
        
        
        int value = 0;
        for ( int i = 0; i < count.length; i++ ) {
            while (count[i] > 0) {
                arr[value] = i;
                value++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] = new Random().nextInt(100000000);
        }
        System.out.println(1);
//        int[] arr = { 8, 9,10000,100000000};
        long startTime = System.currentTimeMillis();
        CountSort.countSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }

}