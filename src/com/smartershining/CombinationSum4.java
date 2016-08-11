package com.smartershining;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smartershining on 16-8-9.
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i < num) break;
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }


}
