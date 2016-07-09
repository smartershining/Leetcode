package com.smartershining;

/**
 * Created by smartershining on 16-7-7.
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
