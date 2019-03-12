package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenkx
 * @Date 2019/3/11 21:07
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 **/
public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(0==l1.val){
            return l2;
        }
        if (0==l2.val){
            return l1;
        }
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        add(list1,list2,l1,l2);

        return null;
    }
    private void add(List list1,List list2,ListNode l1, ListNode l2){
        if(l1!=null){
            list1.add(l1.val);
        }
        if(l2!=null){
            list2.add(l2.val);
        }
        if(l1.next==null && l2.next==null){
            return;
        }else{
            if(l1.next==null){
                 add(list1,list2,l1,l2.next);
            }else if(l2.next==null){
                 add(list1,list2,l1.next,l2);
            }else {
                add(list1,list2,l1.next,l2.next);
            }
        }


    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
