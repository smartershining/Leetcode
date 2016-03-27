package com.smartershining;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by smartershining on 16-3-22.
 */
public class SumClosest3 {
    public  int threeSumCloset(int []nums, int target){
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);


        for(int i  =0 ;i < nums.length; ++ i){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if(diff == 0){
                    return  sum;
                }
                if(diff < min){
                    diff = min;
                    result = sum;
                }
                if(sum < target){
                    j ++;
                }else{
                    k ++;
                }
            }
        }
        return result;
    }
}
