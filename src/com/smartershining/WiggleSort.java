package com.smartershining;

import java.util.Arrays;

/**
 * Created by smartershining on 16-5-5.
 */
public class WiggleSort {
    public static int[] wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length < 3) {
            return nums;
        }

        int i;
        for (i = 1; i < nums.length - 1; i += 2) {
            int temp = nums[i];
            if (nums[i] <= nums[i - 1] || nums[i] <= nums[i + 1]) {
                if (nums[i - 1] > nums[i + 1]) {
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                } else {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        if (i == nums.length - 1 && nums[i] < nums[i - 1]) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 5, 6, 4, 7};
        a = wiggleSort(a);
        for (int x : a)
            System.out.print(x + " ");

    }
}
