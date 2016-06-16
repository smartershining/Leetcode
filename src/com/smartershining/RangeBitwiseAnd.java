package com.smartershining;

/**
 * Created by smartershining on 16-5-9.
 */

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * <p>
 * For example, given the range [5, 7], you should return 4.
 */
public class RangeBitwiseAnd {
    public static int rangeBitwiseAnd(int n, int m) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return m << i;
    }
}
