package com.smartershining;

/**
 * Created by smartershining on 16-6-13.
 */

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        ListNode end = head;
        int length = 0;
        while (end.next != null) {
            end = end.next;
            length++;
        }
        length++;
        k = k % length;
        if (length == k) {
            return dummy.next;
        }
        k = length - k;
        while (k > 0) {
            node = node.next;
            k--;
        }
        end.next = dummy.next;
        dummy.next = node.next;
        node.next = null;
        return dummy.next;

    }
}
