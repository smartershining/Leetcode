package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Given a linked list, swap every two adjacent nodes and return its head.

 *  For example,
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */
public class SwapPairs {
    public  ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) {
            return  head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return  dummy.next;
    }
}
