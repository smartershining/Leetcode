package com.smartershining;

/**
 * Created by smartershining on 16-7-29.
 */

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int cur = 0;
        int i;
        int j;
        for (i = 0; i < nums.length; ) {
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now) {
                    break;
                }
                if (j - i < 2) {
                    nums[cur++] = now;
                }
            }
            i = j;
        }
        return cur;
    }
}
