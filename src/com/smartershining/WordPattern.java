package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 * Here follow means a full match, such that there
 * is a bijection between a letter in pattern and a non-empty word in str.

 * Examples:

 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.

 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a
 * single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if (pattern.length() != word.length) {
            return false;
        }
        boolean flag = true;
        for (int i = 0; i < pattern.length(); ++i) {
            for (int j = i; j < pattern.length(); ++j) {
                if (pattern.charAt(i) == pattern.charAt(j) && word[i].equals(word[j]))
                    continue;
                if (pattern.charAt(i) != pattern.charAt(j) && !word[i].equals(word[j]))
                    continue;
                else {
                    flag = false;
                    break;
                }

            }
        }
        return flag;
    }
}