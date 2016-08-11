package com.smartershining;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by smartershining on 16-8-11.
 */

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return left > right ? left + 1 : right + 1;
        } else {
            return left < right ? left + 1 : right + 1;
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curNum--;

            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                depth++;
            }
        }
        return depth;

    }
}
