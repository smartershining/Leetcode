package com.smartershining;

/**
 * Created by smartershining on 16-5-6.
 */

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2
 */
public class numDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0")) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[s.length()];
        dp[0] = 1;

        if (isValid(s.substring(0, 1))) {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }

        for (int i = 2; i <= len; i++) {
            if (isValid(s.substring(i - 1, i))) {
                dp[i] += dp[i - 1];
            }
            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num > 0 && num < 27;
    }
}
