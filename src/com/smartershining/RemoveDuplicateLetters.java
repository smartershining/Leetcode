package com.smartershining;

/**
 * Created by smartershining on 16-6-25.
 */

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example:
 * Given "bcabc"
 * Return "abc"
 * <p>
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--nums[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
