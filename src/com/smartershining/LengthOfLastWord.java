package com.smartershining;

/**
 * Created by smartershining on 16-3-22.
 */
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 * If the last word does not exist, return 0.

 * Note: A word is defined as a character sequence consists of non-space characters only.

 * For example,
 * Given s = "Hello World",
 * return 5.
 **/

public class LengthOfLastWord {
   public  int lengthOfLastword(String s) {
     if(s.length() ==0 || s == null)
          return 0;

      int count = 0;
   for(int i = s.length() - 1; i >= 0; -- i){
     if(s.charAt(i) != ' ')
        count ++;
      if(s.charAt(i) == ' ' && count != 0)
         return count;
       }
      return  count;
     }
   }
