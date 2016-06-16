package com.smartershining;

/**
 * Created by smartershining on 16-5-13.
 */

/**
 * Invert a binary tree.
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * to
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public static TreeNode invertBinaryTree(TreeNode root) {
        help(root);
        return root;
    }

    public static void help(TreeNode node) {
        if (node != null) {
            TreeNode newNode = node.left;
            node.left = node.right;
            node.right = newNode;
            help(node.left);
            help(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);

        root.left = left;

        root = invertBinaryTree(root);
        System.out.println(root.val + " " + root.right.val);
    }

}
