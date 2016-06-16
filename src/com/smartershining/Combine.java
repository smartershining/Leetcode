package com.smartershining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smartershining on 16-5-12.
 */

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        help(1, n, k, list, lists);
        return lists;
    }

    public void help(int cur, int n, int k, List<Integer> list, ArrayList<List<Integer>> lists) {
        if (list.size() == k) {
            lists.add(new ArrayList<Integer>(list));
            return;

        }
        for (int i = cur; i <= n; i++) {
            list.add(i);
            help(i + 1, n, k, list, lists);
            list.remove(list.size() - 1);
        }
    }


}
