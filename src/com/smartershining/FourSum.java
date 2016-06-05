package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-6-4.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);

                        if (!hashSet.contains(list)) {
                            hashSet.add(list);
                            lists.add(list);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return lists;
    }

    static class Main<T> {

        public List<T> fillList(T t, int size) {

            System.out.println(t);
            List<T> list = new ArrayList<T>();
            for (int i = 0; i < size; i++) {
                list.add(t);
            }

            return list;
        }

    }

    public static void main(String[] args) {
        Main<String> m = new Main<String>();
        List<String> list = m.fillList("findingsea", 5);
        System.out.println(list.toString());
    }
}
