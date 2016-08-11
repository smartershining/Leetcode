package com.smartershining;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

/**
 * Created by smartershining on 16-8-9.
 */


public class levelOrderBottom {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        current.offer(root);

        while (!current.isEmpty()) {
            TreeNode node = current.poll();
            list.add(node.val);
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                lists.add(list);
                list = new ArrayList<>();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = lists.size() - 1; i >= 0; i--) {
            result.add(lists.get(i));
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        List list = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        next.offer(node.left);
                    }
                    if (node.right != null) {
                        next.offer(node.right);
                    }
                }
            }
            lists.add(list);
            queue = next;
            next = new LinkedList<>();
            list = new ArrayList();
        }
        Collections.reverse(lists.subList(0, lists.size()));
        return lists;
    }

}
