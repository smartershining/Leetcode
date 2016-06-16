package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class BuildTree {
    public  TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder.length != postorder.length){
            return  null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }


    private TreeNode myBuildTree(int []inorder, int instart,int inend,int[] postorder, int poststart,int postend){
        if(instart > inend){
            return  null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int position = findPosition(inorder, instart,inend,postorder[postend]);
        root.left = myBuildTree(inorder,instart,position - 1,
                postorder,poststart,position - instart + poststart - 1);
        root.right = myBuildTree(inorder,position + 1, inend, postorder,
                position -instart + poststart,postend - 1);
        return  root;
    }
    private  int findPosition(int[] inorder,int instart,int inend,int key){
        for(int i = instart; i <= inend; ++ i){
            if(inorder[i] == key){
                return  i;
            }
        }
        return  -1;
    }
}
