package com.smartershining;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by smartershining on 16-5-29.
 */

/**
 * Palindrome Partitioning
 * Total Accepted: 65620 Total Submissions: 237272 Difficulty: Medium
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Partition2 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return result;
        ArrayList<String> partition = new ArrayList<>();
        addPalidrome(s, 0, partition, result);
        return result;

    }

    private void addPalidrome(String s, int start, List<String> partition, List<List<String>> result) {
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalidrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
