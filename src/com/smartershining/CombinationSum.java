package com.smartershining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smartershining on 16-7-6.
 */

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(lists, cur, 0, target, candidates);
        return lists;
    }

    public void dfs(List lists, List cur, int j, int target, int[] candidates) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(cur);
            lists.add(temp);
            return;
        } else {
            for (int i = j; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    return;
                }
                cur.add(candidates[i]);
                dfs(lists, cur, i, target - candidates[i], candidates);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(candidates, 7).toString());
    }

}
