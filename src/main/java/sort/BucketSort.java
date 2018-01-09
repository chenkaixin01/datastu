package sort;

import java.util.Random;

public class BucketSort {
    /**
     * 桶排序：建立一定长度的数组作为桶（可以是以区间||直接以数组长度），每个数组元素都是一个桶，桶中装的是链表
     *      桶中链表的数据应该可以取整或者以其他区间的方式写入，后一种桶长度 则以值*数组长度/max+1;
     *      桶中以插入排序进行排序，需要与链表的头结点，中间节点，尾节点对比
     * 当桶中数据过多时，插入排序会很影响速率；
     * @param arr
     */
    public static void bucketSort(int[] arr) {
        int max = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int size = (max) / 10 + 1;
        Node[] bucket = new Node[size];
 
        long startTime = System.currentTimeMillis();
        for ( int i : arr ) {
            if (bucket[i / 10] == null) {
                bucket[i / 10] = new Node(i);
            } else {
                insert(i, bucket[i / 10], bucket, i / 10);
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        
        startTime = System.currentTimeMillis();
        int i = 0;
        for ( Node node : bucket ) {
            Node tem = node;
            while (tem != null) {
                arr[i] = tem.data;
                i++;
                tem = tem.next;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    private static void insert(int i, Node head, Node[] bucket, int point) {
        Node newNode = new Node(i);
        Node tem = head;
        /*
         * 值大于头结点，替换头结点
         */
        if(i<head.data){
            bucket[point] = newNode;
            newNode.next = tem;
            tem.pre=newNode;
            return;
        }
        /*
         * 值大于中间的某个节点
         */
        while (tem.next != null) {
            if (i >= tem.data) {
                tem = tem.next;
            } else {
                newNode.pre = tem.pre;
                tem.pre.next = newNode;
                newNode.next = tem;
                tem.pre = newNode;
                return;
            }
        }
        /*
         * 链表的最后一个节点的值小于值i
         */
        if (i < tem.data) {
           
                newNode.pre = tem.pre;
                tem.pre.next = newNode;
                newNode.next = tem;
                tem.pre = newNode;
        } else {
            tem.next = newNode;
            newNode.pre = tem;
        }

    }

    private static class Node {
        Node next;
        Node pre;
        int data;

        public Node(int data) {
            this.data = data;

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] = new Random().nextInt(100000000);
        }
        System.out.println(1);
//        int[] arr = { 3, 15, 25, 7, 4, 17, 23 };
        long startTime = System.currentTimeMillis();
        BucketSort.bucketSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
//        for ( int i : arr ) {
//            System.out.println(i);
//        }
    }

}
