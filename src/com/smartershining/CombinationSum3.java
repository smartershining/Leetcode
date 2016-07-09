package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-7-3.
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List lists = new ArrayList<>();
        List list = new ArrayList<>();
        dfs(lists, list, k, n, 0, 0);
        return lists;
    }

    void dfs(List lists, List<Integer> list, int k, int n, int sum, int start) {
        if (list.size() == k && sum == n) {
            List temp = new ArrayList<>(list);
            lists.add(temp);
        } else {
            for (int i = start + 1; i <= 9; i++) {
                list.add(i);
                dfs(lists, list, k, n, sum + i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
