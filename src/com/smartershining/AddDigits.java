package com.smartershining;

/**
 * Created by smartershining on 16-5-13.
 */

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    public static int addDigits(int num) {
        if (num >= 0 && num < 10) {
            return num;
        }
        int result = num;
        while (result >= 10) {
            num = result;
            result = 0;
            while (num > 0) {
                result += num % 10;
                num = num / 10;
            }
        }
        return result;
    }

    public static int add(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(add(19));
    }
}
