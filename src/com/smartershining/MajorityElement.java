package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears
 * more than ⌊ n/2 ⌋ times.

 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majElem = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; ++ i){
            if(nums[i] == majElem){
                count ++;
            }else{
                count --;
            }
            if(count == -1){
                majElem = nums[i];
                count = 1;
            }
        }
        return majElem;
    }
}
