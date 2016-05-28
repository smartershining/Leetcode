package com.smartershining;

/**
 * Created by smartershining on 16-5-28.
 */

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * <p>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }

    public boolean helper(TreeNode node, int sum) {
        if (node != null && node.val == sum && node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && node.right != null)
            return helper(node.left, sum - node.val) || helper(node.right, sum - node.val);
        else if (node.left != null)
            return helper(node.left, sum - node.val);
        else if (node.right != null)
            return helper(node.right, sum - node.val);
        else
            return false;
    }
}
