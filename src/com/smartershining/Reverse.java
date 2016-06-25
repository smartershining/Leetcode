package com.smartershining;

/**
 * Created by smartershining on 16-6-16.
 */
public class Reverse {
    public int reverse(int x) {
        boolean flag = true;
        if (x < 0) {
            flag = false;
        }
        StringBuilder str = new StringBuilder(Integer.toString(Math.abs(x)));
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }

        int result = 0;
        try {
            result = Integer.parseInt(str.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return flag ? result : -result;
    }

    public int reverse2(int x) {
        //flag marks if x is negative
        boolean flag = false;
        if (x < 0) {
            x = 0 - x;
            flag = true;
        }

        int res = 0;
        int p = x;

        while (p > 0) {
            int mod = p % 10;
            p = p / 10;
            res = res * 10 + mod;
        }

        if (flag) {
            res = 0 - res;
        }

        return res;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse2(1534236469));
    }

}
