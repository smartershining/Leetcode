package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-7-30.
 */

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int left, int right) {
        List<TreeNode> list = new ArrayList<>();

        if (left > right) {
            list.add(null);
            return list;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> lTree = helper(left, i - 1);
            List<TreeNode> rTree = helper(i + 1, right);

            for (TreeNode l : lTree) {
                for (TreeNode r : rTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    list.add(cur);
                }
            }
        }
        return list;
    }
}
