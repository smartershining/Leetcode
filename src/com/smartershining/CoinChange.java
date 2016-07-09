package com.smartershining;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by smartershining on 16-7-5.
 */

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> amountQueue = new LinkedList<>();
        Queue<Integer> stepQueue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        amountQueue.offer(0);
        stepQueue.offer(0);
        set.add(0);

        while (amountQueue.size() > 0) {
            int temp = amountQueue.poll();
            int step = stepQueue.poll();

            if (temp == amount) {
                return step;
            } else {
                for (int coin : coins) {
                    if (temp > amount) {
                        continue;
                    } else {
                        if (!set.contains(temp + coin)) {
                            amountQueue.offer(temp + coin);
                            stepQueue.offer(step + 1);
                            set.add(temp + coin);
                        }
                    }
                }
            }
        }
        return -1;

    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i + coin <= amount) {
                    if (dp[i] != Integer.MAX_VALUE) {
                        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
