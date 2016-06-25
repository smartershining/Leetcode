package com.smartershining;

import java.util.Stack;

/**
 * Created by smartershining on 16-6-22.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int temp = 0;
        int start = -1;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    if (stack.empty()) {
                        result = Math.max(result, i - start);
                    } else {
                        result = Math.max(result, i - (int) stack.peek());
                    }
                } else {
                    start = i;
                }
            }
        }
        return result;

    }
}
