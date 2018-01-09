package sort;

import java.util.Random;
/**
 * 831833
 * @author 28374
 *
 */
public class SelectSort {
    /**
     * 选择排序：选出数组中的最大值，将最大值与最后的值交换；程序运行后的，数组末尾已经排序的部分不再遍历
     * 百万随机数排序耗时：831833毫秒，约14分钟；
     * @param arr
     */
    public static void selectSort(int[] arr){
        int max;
        int n;
        for(int i=0;i<arr.length;i++){
            max = 0;
            n = 0;
            for(int j=0;j<arr.length-i;j++){
                if(max<arr[j]){
                     max = arr[j];
                     n = j;
                }
                if(j==(arr.length-i-1)){
                     swap(arr,n,j);
                }
            }
        }
    }

    private static void swap(int[] arr, int n, int j) {
        int tem;
        tem = arr[n];
        arr[n]=arr[j];
        arr[j]=tem;
    }
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(1000000);
            }
        System.out.println(1);
//        int[] arr = { 8, 5, 6, 7, 2, 3 };
        long startTime=System.currentTimeMillis();
        SelectSort.selectSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }
}
