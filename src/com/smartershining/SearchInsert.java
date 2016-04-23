package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 * You may assume no duplicates in the array.

 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int hi = nums.length - 1;
        int low = 0;
        while (low < hi){
            int mid = (low + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return nums[low] < target ? low + 1: low ;
    }

}
