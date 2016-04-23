package com.smartershining;

/**
 * Created by smartershining on 16-4-22.
 */

/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProduct {
    public static  int maxProduct(int[] nums) {
        int global = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max_copy = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(min * nums[i], nums[i]),max_copy * nums[i]);
            global = Math.max(global,max);
        }
        return global;
    }
    public  static  void main(String[] args) {
        int[] a = {2,3,-2,4};
        System.out.println(maxProduct(a));
    }
}
