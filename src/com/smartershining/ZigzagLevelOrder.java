package com.smartershining;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by smartershining on 16-5-19.
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        TreeNode node;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    node = stack1.pop();
                    if (node != null) {
                        list.add(node.val);
                        stack2.push(node.left);
                        stack2.push(node.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    node = stack2.pop();
                    if (node != null) {
                        list.add(node.val);
                        stack1.push(node.right);
                        stack1.push(node.left);
                    }
                }
            }
            if (list.size() != 0)
                lists.add(list);
        }
        return lists;
    }
}
