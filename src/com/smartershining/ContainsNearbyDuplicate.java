package com.smartershining;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smartershining on 16-5-1.
 */

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that
 * nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsNearbyDuplicate {
    public Boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
