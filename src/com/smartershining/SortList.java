package com.smartershining;

/**
 * Created by smartershining on 16-5-20.
 */

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;


        ListNode p1 = sortList(fast);
        ListNode p2 = sortList(head);
        return mergeSort(p1, p2);
    }

    public ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null) node.next = head1;
        if (head2 != null) node.next = head2;
        return dummy.next;
    }


}
