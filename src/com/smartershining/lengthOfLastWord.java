package com.smartershining;

/**
 * Created by smartershining on 16-3-22.
 */
public class lengthOfLastWord {
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
