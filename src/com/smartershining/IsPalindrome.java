package com.smartershining;

/**
 * Created by smartershining on 16-6-16.
 */

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right) {
                return false;
            }
            x = (x - left * div) / 10;
            div /= 100;
        }
        return true;

    }
}
