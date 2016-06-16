package com.smartershining;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by smartershining on 16-6-13.
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {


        HashSet<Integer> set = new HashSet<>();
        for (
                int i = 0;
                i < nums.length; i++)

        {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        Iterator<Integer> iterator = set.iterator();
        int[] result = new int[2];
        int i = 0;
        while (iterator.hasNext())

        {
            result[i++] = iterator.next();
        }

        return result;
    }

    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int lastBit = xor - (xor & (xor - 1));

        int group0 = 0;
        int group1 = 0;
        for (int i : nums) {
            if ((i & lastBit) == 0) {
                group0 ^= i;
            } else {
                group1 ^= i;
            }
        }

        int[] result = new int[]{group0, group1};
        return result;


    }


}
