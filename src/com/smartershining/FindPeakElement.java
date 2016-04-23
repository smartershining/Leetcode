package com.smartershining;

/**
 * Created by smartershining on 16-4-22.
 */

/**
 * A peak element is an element that is greater than its neighbors.

 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 * You may imagine that num[-1] = num[n] = -∞.

 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public  static  int findPeakElement(int[] nums) {
       if(nums.length == 1 || nums[0] > nums[1]) {
           return 0;
       }

        for (int i = 1; i  < nums.length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;

    }
    public  static  void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        System.out.println(findPeakElement(a));
    }
}
