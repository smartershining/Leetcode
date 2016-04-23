package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 * A mapping of digit to letters (just like on the telephone buttons) is given below.

 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {
    char[][]  word = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<String>();
        if(digits.length() == 0 || digits == null) {
            return list;
        }
        StringBuilder s = new StringBuilder();
        letterCombinations(list,s, digits,0);
        return list;
    }

    public void letterCombinations(List<String> list, StringBuilder s,String digits, int index){
        if(index >= digits.length()){
            list.add(s.toString());
        }else{
            int k = digits.charAt(index)- '2';
            for(int i = 0; i < word[k].length; ++ i){
                s.append(word[k][i]);
                letterCombinations(list,s,digits,index+1);
                s.deleteCharAt(s.length() - 1);
            }
        }


    }
}
