package com.smartershining;

/**
 * Created by smartershining on 16-6-17.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices == null || prices.length == 0) {
            return result;
        }
        int[] profit = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            profit[i] = prices[i + 1] - prices[i];
        }
        for (int i = 0; i < profit.length; i++) {
            if (profit[i] >= 0) {
                result += profit[i];
            }
        }
        return result;
    }
}
