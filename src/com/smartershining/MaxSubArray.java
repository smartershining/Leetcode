package com.smartershining;

/**
 * Created by smartershining on 16-6-5.
 */

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result + nums[i], nums[i]);
            max = Math.max(result, max);
        }
        return max;
    }
}
