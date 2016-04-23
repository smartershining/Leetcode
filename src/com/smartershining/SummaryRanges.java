package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-4-24.
 */

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) {
            return list;
        }

        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
        }
        int begin = 0;
        int end = 0;
        String temp = "";
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i] + 1) {
                end = i;
                if (begin != end)
                    temp = String.valueOf(nums[begin]) + "->" + String.valueOf(nums[end]);
                else
                    temp = String.valueOf(nums[begin]);
                list.add(temp);
                begin = i + 1;
            }
            if (nums[i + 1] == nums[i] + 1 && i == nums.length - 2) {
                temp = String.valueOf(nums[begin]) + "->" + String.valueOf(nums[nums.length - 1]);
                list.add(temp);
            }
            if (begin == nums.length - 1) {
                list.add(String.valueOf(nums[begin]));
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 8, 9};
        System.out.println(summaryRanges(a).toString());
    }
}
