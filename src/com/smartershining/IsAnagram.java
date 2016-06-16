package com.smartershining;

import java.util.HashMap;

/**
 * Created by smartershining on 16-5-14.
 */

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            } else {
                map1.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            } else {
                map2.put(t.charAt(i), 1);
            }
        }
        return map1.equals(map2) ? true : false;

    }
}
