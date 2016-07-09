package com.smartershining;

/**
 * Created by smartershining on 16-7-9.
 */

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class FindMin {
    public int findMin(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public int help(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (right - left == 1) {
            return Math.min(nums[left], nums[right]);
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int midle = left + (right - left) / 2;

        if (nums[midle] > nums[left]) {
            return help(nums, midle, right);
        } else {
            return help(nums, left, midle);
        }

    }
}
