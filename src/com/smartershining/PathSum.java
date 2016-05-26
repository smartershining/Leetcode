package com.smartershining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smartershining on 16-5-20.
 */

/**
 * Given a binary tree and a sum, find all
 * root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * return
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        dfs(lists, root, root.val, sum, list);
        return lists;
    }

    public void dfs(List<List<Integer>> lists, TreeNode node, int cur, int sum, List<Integer> list) {
        if (cur == sum && node.left == null && node.right == null) {
            List<Integer> copy = new ArrayList<Integer>(list);
            lists.add(copy);
        } else if (node.left != null || node.right != null) {
            if (node.left != null) {
                list.add(node.left.val);
                dfs(lists, node.left, cur + node.left.val, sum, list);
                list.remove(list.size() - 1);
            }
            if (node.right != null) {
                list.add(node.right.val);
                dfs(lists, node.right, cur + node.right.val, sum, list);
                list.remove(list.size() - 1);
            }


        }
    }
}
