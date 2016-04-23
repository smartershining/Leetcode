package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Given an unsorted integer array, find the first missing positive integer.

 *  For example,
 *  Given [1,2,0] return 3,
 *  and [3,4,-1,1] return 2.

 *  Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1) {
                if(nums[i] <=0 || nums[i] > nums.length)
                    break;
                if(nums[i] == nums[nums[i] - 1])
                    break;

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                }
        }
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;

    }
    public static void main(String[] args) {
        int[] a = new int[]{1,1};
        System.out.println(firstMissingPositive(a));
    }
}
