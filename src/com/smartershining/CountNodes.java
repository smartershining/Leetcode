package com.smartershining;

/**
 * Created by smartershining on 16-5-8.
 */

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = getHeight(root.left, true);
        int rHeight = getHeight(root.right, false);
        if (lHeight == rHeight) {
            return (2 << (rHeight + 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }

    public int getHeight(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        while (node != null) {
            if (isLeft) {
                node = node.left;
            } else {
                node = node.right;
            }
            height++;
        }
        return height;
    }


}
