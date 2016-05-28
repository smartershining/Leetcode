package com.smartershining;

/**
 * Created by smartershining on 16-5-28.
 */

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return help(root, 0, 0);
    }

    public int help(TreeNode node, int sum, int cur) {
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum += cur;
        }
        if (node.left != null && node.right != null) {
            return help(node.left, sum, cur) + help(node.right, sum, cur);
        } else if (node.left != null) {
            return help(node.left, sum, cur);
        } else {
            return help(node.right, sum, cur);
        }
    }
}
