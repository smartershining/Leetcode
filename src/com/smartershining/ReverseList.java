package com.smartershining;

/**
 * Created by smartershining on 16-5-4.
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode next;
        while (head != null && head.next != null) {
            next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
