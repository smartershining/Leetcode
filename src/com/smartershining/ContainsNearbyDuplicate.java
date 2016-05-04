package com.smartershining;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smartershining on 16-5-1.
 */
public class ContainsNearbyDuplicate {
    public Boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k)
                    return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
