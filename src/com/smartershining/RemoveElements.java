package com.smartershining;

import java.util.List;

/**
 * Created by smartershining on 16-4-26.
 */
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        System.out.println(removeElements(node, 3).next.next.val);
    }
}
