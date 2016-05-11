package com.smartershining;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by smartershining on 16-5-8.
 */

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //  Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(target - nums[i])) {
                hashMap.put(nums[i], i);
            } else {
                res[0] = hashMap.get(target - nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }

        int[] copyNum = new int[nums.length];
        System.arraycopy(nums, 0, copyNum, 0, nums.length);
        Arrays.sort(copyNum);

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (copyNum[lo] + copyNum[hi] < target) {
                lo = lo + 1;
            } else if (copyNum[lo] + copyNum[hi] > target) {
                hi = hi - 1;
            } else {
                res[0] = copyNum[lo];
                res[1] = copyNum[hi];
                break;
            }
        }
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res[0] && index1 == -1) {
                index1 = i;
            } else if (nums[i] == res[1] && index2 == -1) {
                index2 = i;
            }
        }
        res[0] = index1;
        res[1] = index2;
        Arrays.sort(res);
        return res;
    }
}
