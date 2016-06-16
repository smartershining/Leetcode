package com.smartershining;

/**
 * Created by smartershining on 16-5-1.
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if (lenA > lenB) {
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenB > lenA) {
                headB = headB.next;
                lenB--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }


    public int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public ListNode getIntersection2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;

        ListNode tailA = null;
        ListNode tailB = null;
        while (true) {
            if (pa == null) {
                pa = headB;
            }
            if (pb == null) {
                pb = headA;
            }
            if (pa.next == null) {
                tailA = pa;
            }
            if (pb.next == null) {
                tailB = pb;
            }
            if (tailA != null && tailB != null && tailA != tailB) {
                return null;
            }

            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
    }
}
