package com.smartershining;

/**
 * Created by smartershining on 16-4-22.
 */

/**
 * Rotate an array of n elements to the right by k steps.

 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class Rotate {
    public  static  void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] a = new int[k];
        int j = 0;
        for(int i = nums.length - k ; i < nums.length; i++) {
            a[j] = nums[i];
            j++;
        }
        j = nums.length - 1;
        for(int i = nums.length - k - 1; i >= 0; i --) {
            nums[j] = nums[i];
            j --;
        }
        for(int i = 0; i < k; i++) {
            nums[i] = a[i];
        }
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public  static  void rotate2(int[] nums,int k) {
        k = k % nums.length;
        for(int i = 0; i < k; i ++) {
            int temp = nums[nums.length - 1];
            for(int j = nums.length - 2; j >= 0 ; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public  static  void main(String[] args) {
        int[] a= new int[]{1,2,3,4,5,6,7};
        rotate2(a,3);
    }
}
