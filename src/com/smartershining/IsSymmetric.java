package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 *For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3

 * But the following is not:

 1
 / \
 2   2
 \   \
 3    3

 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return  true;
        }
        return  isSymmetric(root.left,root.right);
    }
    public  boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return  true;
        }
        else if(left == null || right == null) {
            return  false;
        }
        if(left.val != right.val) {
            return false;
        }
        if(!isSymmetric(left.left,right.right)) {
            return  false;
        }
        if(!isSymmetric(left.right, right.left)) {
            return  false;
        }
        return  true;
    }
}
