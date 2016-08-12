package com.smartershining;

/**
 * Created by smartershining on 16-8-12.
 */

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Merge2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] helper = new int[m];
        for (int i = 0; i < m; i++) {
            helper[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (helper[i] < nums2[j])
                nums1[k++] = helper[i++];
            else
                nums1[k++] = nums2[j++];
        }

        while (i < m) nums1[k++] = helper[i++];
        while (j < n) nums1[k++] = nums2[j++];

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }

        while (j >= 0) nums1[k--] = nums2[j--];
    }
}
