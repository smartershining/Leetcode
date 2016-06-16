package com.smartershining;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by smartershining on 16-5-10.
 */

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest
 * element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();

        for (int i : nums) {
            p.offer(i);
            if (p.size() > k) {
                p.poll();
            }
        }
        return p.peek();
    }
}
