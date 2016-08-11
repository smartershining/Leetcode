package com.smartershining;

import java.util.Arrays;
import java.util.List;

/**
 * Created by smartershining on 16-8-11.
 */

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class getRow {
    public List<Integer> getRow(int rowIndex) {
        Integer[] nums = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i)
                    nums[j] = 1;
                else
                    nums[j] += nums[j - 1];
            }
        }
        return Arrays.asList(nums);
    }
}
