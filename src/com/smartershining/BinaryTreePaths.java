package com.smartershining;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-8-11.
 */
public class BinaryTreePaths {
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs("", root);
        return list;

    }

    public void dfs(String s, TreeNode node) {
        if (node.left == null && node.right == null) {
            s += node.val;
            list.add(s.toString());
        }
        s += node.val + "->";
        if (node.left != null) {
            dfs(s, node.left);
        }
        if (node.right != null) {
            dfs(s, node.right);
        }
    }

}
