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
        int sum = l1.val+l2.val;
        ListNode result = new ListNode(sum%10);
        if(null==l1.next && null==l2.next){
            if(sum>9){
                result.next=new ListNode(sum/10);
            }
            return result;
        }
        if(null==l1.next){
            l1.next=new ListNode(0);
        }
        if(null==l2.next){
            l2.next = new ListNode(0);
        }
        add(l1.next,l2.next,sum/10,result);
        return result;
    }

    private void add(ListNode l1,ListNode l2,int bit,ListNode result){
        int sum = l1.val+l2.val+bit;
        result.next = new ListNode(sum%10);
        if(null != l1.next && null != l2.next){
            add(l1.next,l2.next,sum/10,result.next);
        }else if(null != l1.next && null == l2.next){
            add(l1.next,new ListNode(0),sum/10,result.next);
        }else if(null == l1.next && null != l2.next){
            add(new ListNode(0),l2.next,sum/10,result.next);
        }else{
            if(sum>9){
                result.next.next = new ListNode(sum/10);
            }
            return;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
