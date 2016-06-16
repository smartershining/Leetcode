package com.smartershining;

/**
 * Created by smartershining on 16-6-6.
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 0; i < length - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            left[i] *= right[i];
        }
        return left;
    }

    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * left;
            left = left * nums[i];
        }
        return result;
    }
}
