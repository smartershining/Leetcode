package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given a binary tree, determine if it is height-balanced.

 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(height(root.left) - height(root.right)) < 2){
            return isBalanced(root.left) && isBalanced(root.right);
        }else{
            return false;
        }

    }
    public int height(TreeNode root){
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }
}
