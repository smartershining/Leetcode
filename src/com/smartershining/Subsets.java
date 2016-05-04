package com.smartershining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smartershining on 16-4-26.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        Arrays.sort(nums);
        int length = nums.length;
        long total = (long) Math.pow(2, length);

        int index;

        for (int i = 0; i < total; i++) {
            List<Integer> list = new ArrayList<Integer>();
            index = i;

            while (index != 0) {
                int j = Long.numberOfTrailingZeros(index);
                list.add(nums[j]);
                index ^= (1 << j);

            }
            lists.add(list);
        }
        return lists;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), lists);
        return lists;

    }

    public static void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> lists) {
        lists.add(new ArrayList<Integer>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, lists);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 5};
        System.out.println(subsets2(a).toString());
    }


}
