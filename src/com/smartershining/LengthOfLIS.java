package com.smartershining;

/**
 * Created by smartershining on 16-5-26.
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }


    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] > tails[len]) {
                tails[++len] = nums[i];
            } else {
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }

    public int binarySearch(int[] tails, int min, int max, int target) {
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (tails[mid] == target) {
                return mid;
            } else if (tails[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}
