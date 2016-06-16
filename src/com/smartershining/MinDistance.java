package com.smartershining;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by smartershining on 16-6-2.
 */

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < length2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < length1 + 1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j < length2 + 1; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1);
                    min = Math.min(min, dp[i - 1][j] + 1);
                    dp[i][j] = min;
                }
            }
        }

        return dp[length1][length2];
    }
}
