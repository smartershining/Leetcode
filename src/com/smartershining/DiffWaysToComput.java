package com.smartershining;

/**
 * Created by smartershining on 16-6-17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * <p>
 * Example 1
 * Input: "2-1-1".
 * <p>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * <p>
 * <p>
 * Example 2
 * Input: "2*3-4*5"
 * <p>
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class DiffWaysToComput {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        boolean flag = true;
        if (input == null || input.length() == 0) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                flag = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (Integer a : left) {
                    for (Integer b : right) {
                        switch (c) {
                            case '+':
                                result.add(a + b);
                                break;
                            case '-':
                                result.add(a - b);
                                break;
                            case '*':
                                result.add(a * b);
                                break;
                        }
                    }
                }
            }
        }
        if (flag) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
