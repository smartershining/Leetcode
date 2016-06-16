package com.smartershining;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by smartershining on 16-5-4.
 */
public class MaxPathSum {
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
        int result = 0;
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            queue.add(node.left);
            queue.add(node.right);
            result = Math.max(result, maxPathHelper(root));
        }
        return 0;
    }

    public static int maxPathHelper(TreeNode node) {
        return 0;
    }
}
