package com.smartershining;

/**
 * Created by smartershining on 16-8-11.
 */

import java.util.Arrays;
import java.util.List;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 */
public class TrailingZeros {
    public int trailingZeros(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        for (int i = 5; n / i >= 1; ) {
            count += n / i;
            n /= 5;
        }
        return count;
    }
}
