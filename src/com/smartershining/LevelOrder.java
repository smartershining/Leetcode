package com.smartershining;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by smartershining on 16-6-21.
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode cur = queue1.poll();
                    if (cur != null) {
                        list.add(cur.val);
                        queue2.offer(cur.left);
                        queue2.offer(cur.right);
                    }
                }
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode cur = queue2.poll();
                    if (cur != null) {
                        list.add(cur.val);
                        queue1.offer(cur.left);
                        queue1.offer(cur.right);
                    }
                }

            }
            if (list.size() != 0)
                lists.add(list);
        }
        return lists;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List lists = new ArrayList();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }


}
