package com.smartershining;

/**
 * Created by smartershining on 16-5-4.
 */
public class Canjump {
    public static boolean canjump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reach = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1 ? true : false;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        if (canjump(a)) {
            System.out.println("OK");
        }
    }
}
