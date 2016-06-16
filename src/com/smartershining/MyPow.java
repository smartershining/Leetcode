package com.smartershining;

/**
 * Created by smartershining on 16-5-19.
 */

/**
 * Implement pow(x, n)
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = x;
        n = n - 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = result * x;
                n = n - 1;
            } else {
                result = result * result;
                n = (n >> 1);
            }
        }
        return result;
    }
}
