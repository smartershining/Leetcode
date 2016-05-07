package com.smartershining;

/**
 * Created by smartershining on 16-5-7.
 */

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class TitleToNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
