package com.smartershining;

/**
 * Created by smartershining on 16-5-12.
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }


}
