package sort;

import java.util.ArrayList;
import java.util.Random;

public class RadexSort {

    private static ArrayList[] helper = new ArrayList[10];

    /*
     * 不能使用foreach初始化，否则初始化不成功
     */
    static {
        for (int i = 0;i<helper.length;i++ ) {
            helper[i]=new ArrayList();
        }
    }

    /**
     * 基数排序，从数的低位或者高位开始排列，低位从个位开始排列，入桶后不需要排序，不需要插入；
     *        开始以自己写的链表作为容器，可能是功力不够，所以很慢，而后改成了使用java 的ArrayList作为容器还过的去；
     * @param arr
     */
    public static void radexSort(int[] arr) {
        int d = 0;
        int point = 0;
        while (true) {

            d++;
            for ( int i : arr ) {
                point = getDigit(i, d);
                inputBucket(point, i);
            }

            if (helper[0].size() == arr.length) {
                break;
            }

            int index = 0;
            for ( ArrayList list : helper ) {
                for ( Object obj : list ) {
                    arr[index++] = (Integer) obj;
                }
            }
            cleanAll();
        }

    }

    private static void cleanAll() {
        for ( ArrayList list : helper ) {
            list.clear();
        }
    }

    private static void inputBucket(int point, int i) {
        switch (point) {
            case 0:
                helper[0].add(i);
                break;
            case 1:
                helper[1].add(i);
                break;
            case 2:
                helper[2].add(i);
                break;
            case 3:
                helper[3].add(i);
                break;
            case 4:
                helper[4].add(i);
                break;
            case 5:
                helper[5].add(i);
                break;
            case 6:
                helper[6].add(i);
                break;
            case 7:
                helper[7].add(i);
                break;
            case 8:
                helper[8].add(i);
                break;
            case 9:
                helper[9].add(i);
                break;
        }
    }

    private static int getDigit(int i, int d) {
        return i / (int) Math.pow(10, d - 1) % 10;
    }

    public static void main(String[] args) {
         int[] arr = new int[100000000];
         for ( int i = 0; i < arr.length; i++ ) {
         arr[i] = new Random().nextInt(100000000);
         }
         System.out.println(1);
//        int[] arr = { 123, 1, 8, 28, 46, 36, 27 };
        long startTime = System.currentTimeMillis();
        RadexSort.radexSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }
}

