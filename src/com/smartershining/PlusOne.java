package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-4-28.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int one = 1;
        int sum;
        for (int i = digits.length - 1; i >= 0 && one > 0; i--) {
            sum = one + digits[i];
            one = (sum) / 10;
            digits[i] = sum % 10;

        }
        if (one == 0)
            return digits;
        int[] re = new int[digits.length + 1];
        re[0] = 1;
        for (int i = 1; i < digits.length; i++) {
            re[i] = digits[i];
        }
        return re;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9};
        System.out.println(plusOne(a)[0] + plusOne(a)[1]);
    }
}
