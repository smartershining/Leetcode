package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-8-1.
 */

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent
 * numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int length = triangle.size();
        int[] result = new int[length];
        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    result[j] = result[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    result[j] = result[j] + triangle.get(i).get(j);
                } else {
                    result[j] = Math.min(result[j], result[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (result[i] < min)
                min = result[i];
        }
        return min;
    }

}
