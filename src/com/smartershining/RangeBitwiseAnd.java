package com.smartershining;

/**
 * Created by smartershining on 16-5-9.
 */
public class RangeBitwiseAnd {
    public static int rangeBitwiseAnd(int n, int m) {
        int sum = n;
        for (int i = n + 1; i <= m; i++) {
            sum = sum & i;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
