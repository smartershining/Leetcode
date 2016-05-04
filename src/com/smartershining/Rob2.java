package com.smartershining;

/**
 * Created by smartershining on 16-4-26.
 */
public class Rob2 {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long total = (long) Math.pow(2, nums.length);
        int result = 0;
        for (int i = 0; i < total; i++) {
            int temp = 0;
            if (isValid(i)) {
                for (int j = 0; j < nums.length; j++) {
                    if (((i >> j) & 1) == 1)
                        temp += nums[j];
                }
            }
            result = Math.max(result, temp);
        }
        return result;
    }

    public static boolean isValid(int num) {
        String s = Long.toBinaryString(num);
        if (s.charAt(0) == '1' && s.charAt(s.length() - 1) == '1')
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1')
                return false;
        }
        return true;
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(robHelp(nums, 0, nums.length - 2), robHelp(nums, 1, nums.length - 1));
        }
    }

    public static int robHelp(int[] num, int begin, int end) {
        int length = end - begin + 1;
        int[] dp = new int[length];
        dp[0] = num[begin];
        dp[1] = Math.max(num[begin], num[begin + 1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + num[begin + i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob2(new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29
                , 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45,
                435,
                7,
                36,
                57,
                86,
                81,
                72}));
    }
}
