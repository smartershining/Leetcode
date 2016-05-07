package com.smartershining;

/**
 * Created by smartershining on 16-5-7.
 */

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class BuildTree2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, root.val);

        root.left = buildTreeHelper(preorder, prestart + 1, position - instart + prestart, inorder, instart, position - 1);
        root.right = buildTreeHelper(preorder, position - instart + prestart + 1, preend, inorder, position + 1, inend);
        return root;
    }

    public int findPosition(int[] inorder, int instart, int inend, int key) {
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
