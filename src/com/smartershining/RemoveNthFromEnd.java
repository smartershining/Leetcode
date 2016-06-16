package com.smartershining;

/**
 * Created by smartershining on 16-5-13.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        int length = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        length = length - n;
        node = dummy;
        while (length-- > 0) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;


    }

}
