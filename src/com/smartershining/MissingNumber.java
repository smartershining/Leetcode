package com.smartershining;

/**
 * Created by smartershining on 16-5-8.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int[] helper = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] <= nums.length) {
                helper[nums[i]] = 1;
            }
        }
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        int sum = 0;
        int len = nums.length;

        for (int i : nums) {
            sum += i;
        }
        return (len + 1) * len / 2 - sum;

    }

    public static int missingNumber3(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {3, 0, 1};
        System.out.println(missingNumber3(a));
    }
}
