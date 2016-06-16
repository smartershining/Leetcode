package com.smartershining;

/**
 * Created by smartershining on 16-5-28.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        help(list, "", n, n);
        return list;
    }

    public void help(List<String> list, String s, int left, int right) {
        if (right > left) {
            return;
        }
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if (left > 0)
            help(list, s + ')', left - 1, right);
        if (right > 0)
            help(list, s + '(', left, right - 1);
    }
}
