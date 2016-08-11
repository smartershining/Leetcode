package com.smartershining;

/**
 * Created by smartershining on 16-8-6.
 */

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Write a function to determine if a given target is in the array.
 */
public class Search2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[hi]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                hi--;
            }
        }
        return false;
    }
}
