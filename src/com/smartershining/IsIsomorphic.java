package com.smartershining;

/**
 * Created by smartershining on 16-3-27.
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings s and t, determine if they are isomorphic.

 * Two strings are isomorphic if the characters in s can be replaced to get t.

 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 * For example,
 * Given "egg", "add", return true.

 * Given "foo", "bar", return false.

 * Given "paper", "title", return true.

 * Note:
 * You may assume both s and t have the same length.
 */

public class IsIsomorphic {
   public  boolean  isIsomorphic(String s,String t) {
       if (s.length() == 0 && t.length() == 0) {
           return true;
       }
       HashMap<Character, Character> map = new HashMap<Character, Character>();
       for (int i = 0; i < s.length(); ++i) {
           char c1 = s.charAt(i);
           char c2 = t.charAt(i);
           Character key = getKey(map,c2);
           if(key != null && key != c1){
               return  false;
           }else if(map.containsKey(c1)){
               if(map.get(c1) != c2){
                   return  false;
               }
           }else{
               map.put(c1,c2);
           }
       }
       return  true;
   }
    public  Character getKey(HashMap<Character,Character> map, Character value){
        for(Map.Entry<Character,Character> entry: map.entrySet()){
            if(entry.getValue().equals(value)){
                return entry.getKey();
            }
        }
        return  null;
    }
}
