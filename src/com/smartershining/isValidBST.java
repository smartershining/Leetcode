package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-3-21.
 */

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

// 【暴力遍历法】【AC】
public class isValidBST {
    public  boolean dfsLeft(TreeNode root, int value){
        if(root == null)  return true;
        if(root.val >= value) return  false;
        return dfsLeft(root.left,value) && dfsLeft(root.right,value);
    }

    public  boolean dfsRight(TreeNode root, int value){
        if(root == null)  return true;
        if(root.val <= value) return  false;
        return dfsRight(root.left,value) && dfsRight(root.right,value);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!dfsLeft(root.left,root.val) && !dfsRight(root.right,root.val))
            return  false;
        return isValidBST(root.left) && isValidBST(root.right);

    }
}

//中序遍历o(n)

class solution{
    List<Integer> list = new ArrayList<Integer>();
    public  boolean isValidBST(TreeNode root){
        if(root == null) return  true;
        if(root.left == null && root.right == null) return  true;
        InOrderTraversal(root);
        for(int i = 1; i < list.size(); ++ i){
            if(list.get(i) <= list.get(i - 1))
                return  false;
        }
        return true;

    }
    public  void  InOrderTraversal(TreeNode root){
        if(root == null)  return ;
        InOrderTraversal(root.left);
        list.add(root.val);
        InOrderTraversal(root.right);
    }
}



