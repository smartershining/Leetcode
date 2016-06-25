package com.smartershining;

/**
 * Created by smartershining on 16-6-23.
 */
public class Jump {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int last = 0;
        int res = 0;
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                ++res;
                last = far;
            }
            far = Math.max(far, nums[i] + i);
        }
        return res;
    }
}
