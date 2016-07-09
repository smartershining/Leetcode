package com.smartershining;

/**
 * Created by smartershining on 16-7-3.
 */

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * Example:
 * <p>
 * Given [3, 1, 5, 8]
 * <p>
 * Return 167
 * <p>
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int length = nums.length + 2;
        int[][] dp = new int[length][length];
        int[] data = new int[length];

        data[0] = 1;
        System.arraycopy(nums, 0, data, 1, length - 2);
        data[length - 1] = 1;
        data[0] = 1;

        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right], data[left - 1] * data[k] * data[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        MaxCoins maxCoins = new MaxCoins();
        System.out.println(maxCoins.maxCoins(nums));
    }
}
