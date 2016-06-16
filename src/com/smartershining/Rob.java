package com.smartershining;

import sun.reflect.generics.tree.Tree;

/**
 * Created by smartershining on 16-4-24.
 */
public class Rob {

    public static int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }

    public static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + node.val;
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);

        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(rob(root));
    }
}
