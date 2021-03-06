package com.smartershining;

/**
 * Created by smartershining on 16-5-4.
 */

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it
 * has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = (n >> 1);
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 2147483647;

        System.out.println(hammingWeight(a));
    }
}
