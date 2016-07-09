package com.smartershining;

/**
 * Created by smartershining on 16-7-7.
 */

class Bucket {
    int low;
    int high;

    public Bucket() {
        low = -1;
        high = -1;
    }
}

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        Bucket[] bucket = new Bucket[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new Bucket();
        }

        double intervel = ((double) nums.length) / (max - min);
        for (int i = 0; i < nums.length; i++) {
            int index = (int) ((nums[i] - min) * intervel);

            if (bucket[index].low == -1) {
                bucket[index].low = nums[i];
                bucket[index].high = nums[i];
            } else {
                bucket[index].low = Math.min(bucket[index].low, nums[i]);
                bucket[index].high = Math.max(bucket[index].high, nums[i]);
            }

        }

        int gap = 0;
        int pre = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i].low != -1) {
                gap = Math.max(gap, bucket[i].low - bucket[pre].high);
                pre = i;
            }
        }
        return gap;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        MaximumGap gap = new MaximumGap();
        System.out.println(gap.maximumGap(nums));
    }

}
