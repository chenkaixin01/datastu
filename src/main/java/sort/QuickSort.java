package sort;

import java.util.Random;

public class QuickSort {
    /**
     * 快速排序：取一个值作为分界将比其大的放左边，小的放右边，利用分治法思想，将其分拆合并
     * 百万随机数排序 136毫秒；千万级耗时1483毫秒；
     * @param arr
     */
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    /**
     * 这个重载方法用来实现递归，从分区方法取得的@pos可作为调用递归的begin或者end，但pos不必再加入排序
     * @param arr
     * @param begin
     * @param end
     */
    private static void quickSort(int[] arr,int begin,int end){
        if(begin<end){
            int pos = partition(arr,begin,end);
            quickSort(arr,begin,pos-1);
            quickSort(arr,pos+1,end);
        }
        
    }
    /**
     * 分区方法：利用pivot=arr[begin]的值作为标准，将比pivot大的值放右边小的放左边
     * @param arr
     * @param begin
     * @param end
     * @param pivot:分界值
     * @param pos 定位最后一个比pivot小的值
     * @return
     */
    private static int partition(int[] arr,int begin,int end){
        int pivot = arr[begin];
        int pos = begin;
        /*
         * int i = begin + 1;
         * begin 的值作为分界值，不用参与比较交换
         */
        for(int i = begin+1;i<=end;i++){
            if(arr[i]<=pivot){
                pos++;
                if(i!=pos){
                    swap(arr,pos,i);
                }
            }		
        }
        /*
         * arr[pos]代表比pivot小的某个值；
         * arr[begin]是pivot的值
         * 为保证左边比pivot小，右边比pivot大 ，需要交换
         */
        swap(arr,pos,begin);
        return pos;
    }
	/*
	 *数值交换
	 */
    private static void swap(int[] arr, int i, int j) {
        int tem;
        tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
    public static void main(String[] args) {
//        int[] arr = {8,5,6,7,2,3};
      int[] arr = new int[10000000];
      for(int i = 0; i < arr.length; i++){
          arr[i] = new Random().nextInt(10000000);
          }
        long startTime=System.currentTimeMillis();
        QuickSort.quickSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println("时间"+":"+(endTime-startTime));
//
//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }
}
