package com.smartershining;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by smartershining on 16-8-3.
 */

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {
    public boolean IsHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            set.add(n);
            n = reverse(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int reverse(int n) {
        int result = 0;
        int digit = 0;
        while (n > 0) {
            digit = n % 10;
            result += digit * digit;
            n = n / 10;
        }
        return result;
    }
}
