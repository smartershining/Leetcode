package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return  null;
        }
        ListNode dummy = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }

        }
        return dummy;
    }
}