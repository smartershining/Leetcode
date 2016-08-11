package com.smartershining;

/**
 * Created by smartershining on 16-8-9.
 */

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Strstr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                return -1;
            }
            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(m) == needle.charAt(j)) {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                    m++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
