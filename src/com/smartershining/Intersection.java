package com.smartershining;

/**
 * Created by smartershining on 16-6-5.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int x : set) {
            result[i++] = x;
        }


        return result;
    }

}
