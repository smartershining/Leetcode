package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class SortedListToBST {

    private ListNode current;
     public  int GetLength(ListNode head) {
         if(head == null) {
             return  0;
         }
         int count = 0;
         while(head != null) {
             head = head.next;
             count ++;
         }
         return count;
     }
     public TreeNode sortedListToBST(ListNode head) {
         int size = GetLength(head);
         current = head;
         return sortListToBSTHelper(size);

     }
    public TreeNode sortListToBSTHelper(int size) {
        if(size < 0) {
            return null;
        }
        TreeNode left = sortListToBSTHelper(size/ 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortListToBSTHelper(size - size / 2 - 1);

        root.left = left;
        root.right = right;
        return      root;

    }
}
