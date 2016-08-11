package com.smartershining;

/**
 * Created by smartershining on 16-8-9.
 */

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class IsPalindrome2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode second = new ListNode(head.val);
        ListNode p = head.next;

        while (p != null) {
            ListNode temp = new ListNode(p.val);
            temp.next = second;
            second = temp;
            p = p.next;
        }

        ListNode p1 = head;
        ListNode p2 = second;

        while (p1 != null) {
            if (p1.val == p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode p1 = secondHead;
        ListNode p2 = p1.next;

        while (p2 != null) {
            p1.next = p2.next;
            p2.next = secondHead;
            secondHead = p2;
            p2 = p1.next;
        }

        p1 = head;
        p2 = secondHead;
        while (p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;

    }
}
