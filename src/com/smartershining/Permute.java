package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-5-21.
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        help(lists, 0, nums);
        return lists;
    }

    public void help(List<List<Integer>> lists, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++)
                list.add(nums[i]);
            lists.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;

                help(lists, start + 1, nums);

                temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
            }
        }
    }
}
