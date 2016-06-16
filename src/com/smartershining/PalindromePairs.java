package com.smartershining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by smartershining on 16-5-26.
 */

/**
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * <p>
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (isPlindrome(s)) {
                if (map.containsKey("")) {
                    if (map.get("") != i) {
                        list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(""));
                        lists.add(list);

                        list = new ArrayList<Integer>();
                        list.add(map.get(""));
                        list.add(i);
                        lists.add(list);
                    }
                }
            }

            String reversed = new StringBuilder(s).reverse().toString();
            if (map.containsKey(reversed)) {
                if (map.get(reversed) != i) {
                    list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(map.get(reversed));
                    lists.add(list);

                }
            }

            for (int k = 1; k < s.length(); k++) {
                String left = s.substring(0, k);
                String right = s.substring(k);

                if (isPlindrome(left)) {
                    String reverseRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reverseRight)) {
                        if (map.get(reverseRight) != i) {
                            list = new ArrayList<Integer>();

                            list.add(map.get(reverseRight));
                            list.add(i);
                            lists.add(list);
                        }
                    }
                }


                if (isPlindrome(right)) {
                    String reverseLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reverseLeft)) {
                        if (map.get(reverseLeft) != i) {
                            list = new ArrayList<Integer>();

                            list.add(i);
                            list.add(map.get(reverseLeft));
                            lists.add(list);
                        }
                    }
                }

            }

        }
        return lists;
    }

    public boolean isPlindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
