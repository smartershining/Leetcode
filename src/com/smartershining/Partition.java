package com.smartershining;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater
 * than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 *
 * Created by smartershining on 16-3-21.
 */

class ListNode {
        int val;
         ListNode next;
         ListNode(int x) { val = x; }
}

public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;

        ListNode firstDummy  = new ListNode(0);
        ListNode secondDummy = new ListNode(0);
        ListNode first = firstDummy;
        ListNode second = secondDummy;

        while(head != null){
            if(head.val < x ){
                first.next = head;
                first = head;
            }else{
                second.next = head;
                second = head;
            }
            head = head.next;
        }
        second.next = null;
        first.next = secondDummy.next;
        return firstDummy.next;
    }


}
