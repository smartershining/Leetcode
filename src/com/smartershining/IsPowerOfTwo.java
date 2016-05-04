package com.smartershining;

/**
 * Created by smartershining on 16-4-25.
 */
public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static boolean isPowerOfTwo2(int n) {
        return n > 0 & ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        if (isPowerOfTwo2(7))
            System.out.println("Yes");
    }
}
