package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-5-7.
 */

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajortyElement {
    public List<Integer> majortyElement(int[] nums) {
        Integer n1 = null, n2 = null;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (n1 != null && nums[i] == n1.intValue()) {
                count1++;
            } else if (n2 != null && nums[i] == n2.intValue()) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                n1 = nums[i];
            } else if (count2 == 0) {
                count2++;
                n2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1.intValue()) {
                count1++;
            } else if (nums[i] == n2.intValue()) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        if (count1 > nums.length / 3) {
            list.add(n1);
        }
        if (count2 > nums.length / 3) {
            list.add(n2);
        }
        return list;
    }
}
