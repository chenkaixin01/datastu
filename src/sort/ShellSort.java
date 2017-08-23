package sort;

import java.util.Random;

public class ShellSort {
    /**
     * 希尔排序:取一定的间隔作为增量，并逐渐增大增量使其合并逐渐构成相对有序的序列，直到完全有序
     * 千万随机数耗时3978毫秒
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int j = 0;
        int temp = 0;
        /*
         * 取二分增量法，
         */
        for ( int increment = arr.length/2; increment > 0; increment /= 2 ) {
            /*
             * 不取每个小序列的第一个数，取后面的数与小序列的前面的数比较，
             */
            for ( int i = increment; i < arr.length; i++ ) {
                temp = arr[i];
                for ( j = i - increment; j >= 0; j -= increment ) {
                    if (temp < arr[j]) {
                        /*
                         * temp与arr[j+increment]不同
                         * temp在循环中固定不变了
                         * 使用temp会丢失数据
                         */
                        arr[j+increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;

            }

        }
    }

    public static void main(String[] args) {
//        int[] arr = { 8, 5, 6, 7, 2, 3 };
        int[] arr = new int[10000000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Random().nextInt(1000000000);
            }
        System.out.println(1);
        long startTime=System.currentTimeMillis();
        ShellSort.shellSort(arr);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);

//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }
}
