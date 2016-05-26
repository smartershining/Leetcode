package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-5-15.
 */

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask
 * yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        double result = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder(str.trim());
        if (sb.charAt(0) == '-') {
            flag = false;
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                result = result * 10 + (sb.charAt(i) - '0');
            } else if (i == 0) {
                if (sb.charAt(i) != '-' && sb.charAt(i) != '+')
                    break;
            } else {
                break;
            }
        }

        System.out.println(result);
        result = flag ? result : -result;
        if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) result = Integer.MIN_VALUE;

        return (int) result;

    }

    public static void main(String[] args) {

        System.out.println(myAtoi("9223372036854775809"));
        System.out.println(Double.MAX_VALUE);
        System.out.println();
        System.out.println(Long.MAX_VALUE);
    }
}
