package com.smartershining;

/**
 * Created by smartershining on 16-8-6.
 */

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head.next;
        while (p != null) {
            ListNode pre = head;
            while (pre != p && pre.val <= p.val) {
                pre = pre.next;
            }
            if (pre != p) {
                int a = p.val;
                while (pre != p) {
                    int b = pre.val;
                    pre.val = a;
                    a = b;
                    pre = pre.next;
                }
                p.val = a;

            }
            p = p.next;
        }
        return dummy.next;
    }

}
