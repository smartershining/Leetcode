package com.smartershining;

import java.util.Stack;

/**
 * Created by smartershining on 16-4-26.
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int value = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return value;
    }
}
