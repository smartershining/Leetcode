package com.smartershining;

import java.util.Vector;

/**
 * Created by smartershining on 16-4-29.
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 3)
            return nums.length;

        int count = 0;
        int j;
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now)
                    break;
                if (j - i < 2)
                    nums[count++] = now;
            }
            i = j;
        }
        return count;

    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums.length;
        }
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(nums[0]);
        vector.add(nums[1]);
        for (int i = 2; i < nums.length; ) {
            int now = nums[i - 2];
            if (nums[i] == now) {
                while (i < nums.length && nums[i] == now)
                    i++;
                if (i < nums.length) {
                    vector.add(nums[i]);
                    if (i + 1 < nums.length)
                        vector.add(nums[i++]);
                    i++;
                }
            } else {
                vector.add(nums[i++]);
            }
        }
        for (int i = 0; i < vector.size(); i++)
            nums[i] = vector.get(i);
        return vector.size();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(removeDuplicates2(a));
    }
}
