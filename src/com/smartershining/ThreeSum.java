package com.smartershining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smartershining on 16-5-11.
 */

/**
 * Given an array S of n integers, are there elements a, b, c in S such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {

                int reminder = 0 - nums[i];
                int j = i + 1;
                int k = len - 1;

                while (j < k) {
                    if (nums[j] + nums[k] < reminder) {
                        j++;
                    } else if (nums[j] + nums[k] > reminder) {
                        k--;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(j);
                        list.add(k);
                        lists.add(list);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j + 1])
                            j++;
                        while (j < k && nums[k] == nums[k - 1])
                            k--;
                    }
                }
            }
        }
        return lists;
    }
}
