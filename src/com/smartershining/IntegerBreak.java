package com.smartershining;

/**
 * Created by smartershining on 16-5-4.
 */
public class IntegerBreak {
    public static int integerBreak(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = Math.max(result, getProduct(i, n));
        }
        return result;
    }

    public static int getProduct(int slice, int n) {
        int[] nums = new int[slice];
        int product = 1;
        int reminder = n - (slice * (n / slice));
        for (int i = 0; i < reminder; i++) {
            nums[i] += 1;
        }
        for (int i = 0; i < slice; i++) {
            nums[i] += n / slice;
            product *= nums[i];
        }

        return product;
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i + 1; j++)
                if (i + j <= n) {
                    dp[i + j] = Math.max(Math.max(dp[i], i) * Math.max(dp[j], j), dp[i + j]);
                }
        }
        return dp[n];
    }


    public static int integerBreak3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 4) return 4;

        int result = 1;
        if (n % 3 == 0) {
            int m = n / 3;
            result = (int) Math.pow(3, m);
        } else if (n % 3 == 1) {
            int m = (n - 4) / 3;
            result = (int) Math.pow(3, m) * 4;
        } else {
            int m = n / 3;
            result = (int) Math.pow(3, m) * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak2(11));
    }
}
