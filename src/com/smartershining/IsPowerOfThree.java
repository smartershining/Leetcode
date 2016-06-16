package com.smartershining;

/**
 * Created by smartershining on 16-5-14.
 */

/**
 * Given an integer, write a function to determine if it is a power of three.
 */
public class IsPowerOfThree {
    private final static double epsilon = 10e-15;

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        double t = Math.log10(n) / Math.log(3);
        System.out.println(t);


        return Math.abs(t - Math.round(t)) < epsilon;

    }

    public boolean isPowerOfThree3(int n) {
        if (n <= 0) {
            return false;
        }
        double t = Math.log10(n) / Math.log10(3);
        return t % 1 == 0 ? true : false;


    }
}
