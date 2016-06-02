package com.smartershining;

import java.util.Stack;

/**
 * Created by smartershining on 16-6-2.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return result.toString();
        }
        if (strs.length == 1) {
            return strs[0];
        }
        result = commonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            result = commonPrefix(result.toString(), strs[i]);
        }
        return result.toString();


    }

    public StringBuilder commonPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return sb;
        }
        int i = 0;
        int length1 = str1.length();
        int length2 = str2.length();

        while (i < length1 && i < length2 && str1.charAt(i) == str2.charAt(i)) {
            sb.append(str1.charAt(i++));
        }
        return sb;
    }
}