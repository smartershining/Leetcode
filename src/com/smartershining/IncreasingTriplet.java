package com.smartershining;

/**
 * Created by smartershining on 16-6-25.
 */

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * <p>
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];
            if (z <= x) {
                x = z;
            } else if (z <= y) {
                y = z;
            } else {
                return true;
            }
        }
        return false;
    }

}
