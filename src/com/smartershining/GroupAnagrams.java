package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-6-10.
 */

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String s = new String(a);
            if (hashmap.containsKey(s)) {
                hashmap.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashmap.put(s, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : hashmap.entrySet()) {
            Collections.sort(entry.getValue());
        }
        lists.addAll(hashmap.values());

        return lists;


    }


}
