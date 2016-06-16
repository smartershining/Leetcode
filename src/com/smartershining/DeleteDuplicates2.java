package com.smartershining;

/**
 * Created by smartershining on 16-5-11.
 */

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (head != null) {
            boolean flag = false;
            if (head.next != null && head.next.val == head.val) {
                flag = true;
            }
            if (flag) {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                head = head.next;
            } else {
                pre.next = head;
                pre = head;
                head = head.next;
            }
        }
        pre.next = null;
        return dummy.next;
    }
}
