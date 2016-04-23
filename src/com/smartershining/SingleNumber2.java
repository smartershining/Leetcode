package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Given an array of integers, every element appears three times except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return  -1;
        }
        int result = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; ++ i) {
            for (int j = 0; j < nums.length; ++ j) {
                bits[i] += ( nums[j] >> i ) & 1;
                bits[i] %= 3;
            }
            result |= ( bits[i] << i );
        }
        return  result;
    }
}
