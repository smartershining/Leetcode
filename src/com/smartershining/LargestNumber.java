package com.smartershining;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by smartershining on 16-8-2.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return -s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
