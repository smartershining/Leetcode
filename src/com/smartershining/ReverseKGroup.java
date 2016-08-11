package com.smartershining;

/**
 * Created by smartershining on 16-8-7.
 */

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head != null) {
            head = reverseNextK(head, k);
        }
        return dummy.next;
    }

    public ListNode reverseNextK(ListNode head, int k) {
        ListNode next = head;
        for (int i = 0; i < k; i++) {
            next = next.next;
            if (next == null) {
                return next;
            }
        }

        ListNode pre = head.next;
        ListNode cur = head.next.next;

        for (int i = 0; i < k - 1; i++) {
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = pre.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new ReverseKGroup().reverseKGroup(node, 2);
    }
}
