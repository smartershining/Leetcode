package com.smartershining;

/**
 * Created by smartershining on 16-4-25.
 */
public class IsPowerOfFour {
    public static boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        while (num != 1) {
            if (num % 4 != 0)
                return false;
            num = num / 4;
        }
        return true;
    }

    public static boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        if (isPowerOfFour2(16)) {
            System.out.println("Yes");
        }
    }
}
