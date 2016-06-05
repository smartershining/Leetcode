package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-6-3.
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].equals("")) {
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" 1"));
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
    }
}
