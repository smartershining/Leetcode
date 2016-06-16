package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given a roman numeral, convert it to an integer.

 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int[] map =new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        int res = 0;
        int length = s.length();
        s += s.charAt(length - 1);
        for (int i = 0; i < length; ++i) {
            if (map[s.charAt(i) - 'A'] >= map[s.charAt(i + 1) - 'A']) {
                res += map[s.charAt(i) - 'A'];
            }
            else {
                res -= map[s.charAt(i) - 'A'];
            }
        }
        return  res;
    }
}
