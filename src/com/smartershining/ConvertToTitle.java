package com.smartershining;

/**
 * Created by smartershining on 16-5-12.
 */

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ConvertToTitle {


    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char c;
        if (n <= 0) {
            return sb.toString();
        }
        n = n - 1;
        while (n >= 0) {
            int reminder = n % 26;
            sb.append((char) ('A' + reminder));
            n = n / 26;
            n--;
        }
        return sb.reverse().toString();
    }

}
