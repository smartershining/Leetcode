package com.smartershining;

import java.util.Stack;

/**
 * Created by smartershining on 16-4-22.
 */

/**
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 * Some examples:

 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvalRPN {
    public  static int evalRPN(String[] tokens) {
        Stack<Integer> a = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i ++) {
            if(tokens[i].equals("+") || tokens[i].equals("-")|| tokens[i].equals("*") || tokens[i].equals("/")) {
                 int operator2 = a.pop();
                 int operator1 = a.pop();
                 int result = 0;
                if(tokens[i].equals("+"))
                    result = operator1 + operator2;
                else if(tokens[i].equals("-"))
                    result = operator1 - operator2;
                else if(tokens[i].equals("*"))
                    result = operator1 * operator2;
                else
                    result = operator1 / operator2;
                a.push(result);
           }
            else {
                a.push(stringToInt(tokens[i]));
            }
        }

        return a.pop();
    }

    public  static int stringToInt(String a) {
        int begin = 0;
        int flage = 1;
        if(a.charAt(0) == '-') {
            begin = 1;
            flage = -1;
        }

        int result = 0;
        for (int i = begin; i < a.length(); i++) {
            result = result * 10 + a.charAt(i) - '0';

        }
        return result * flage;
    }

    public  static  void  main(String[] args) {
        String[] a  = {"3", "-4", "+"};
        System.out.println(evalRPN(a));



    }
}
