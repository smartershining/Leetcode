package com.smartershining;

/**
 * Created by smartershining on 16-5-9.
 */
public class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len];
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
            sum[i] = total;
        }

    }

    public int sumRange(int i, int j) {
        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
}
