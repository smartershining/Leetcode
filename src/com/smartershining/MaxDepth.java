package com.smartershining;

/**
 * Created by smartershining on 16-5-8.
 */

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return DepthHelper(root);
    }

    public int DepthHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(DepthHelper(node.left), DepthHelper(node.right)) + 1;
    }
}
