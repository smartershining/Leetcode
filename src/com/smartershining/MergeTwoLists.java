package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */


/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ptr= dummy;
        while(l1 != null && l2 != null){
            ListNode cur = null;
            if(l1.val < l2.val){
                cur = l1;
                l1 = l1.next;
            }
            else{
                cur = l2;
                l2 = l2.next;
            }
            ptr.next = cur;
            ptr = ptr.next;
        }
        if(l1 == null) ptr.next = l2;
        if(l2 == null) ptr.next = l1;
        return dummy.next;
    }
}
