package com.smartershining;

import java.util.Stack;

/**
 * Created by smartershining on 16-5-9.
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public int kthSmallest2(TreeNode root, int k) {
        int left = findNodesSum(root.left);
        if (left + 1 == k) {
            return root.val;
        } else if (left + 1 < k) {
            return kthSmallest2(root.right, k - left - 1);
        } else {
            return kthSmallest2(root.left, k);
        }
    }

    public int findNodesSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = findNodesSum(node.left) + findNodesSum(node.right) + 1;
        return sum;
    }

}
