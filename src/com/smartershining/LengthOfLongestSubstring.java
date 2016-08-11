package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-8-7.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (left < i && s.charAt(left) != s.charAt(i)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                max = Math.max(max, i - left + 1);
                set.add(s.charAt(i));
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int max = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != -1) {
                while (left < i && s.charAt(left) != s.charAt(i)) {
                    map[s.charAt(left)] = -1;
                    left++;
                }
                left++;
            } else {
                map[s.charAt(i)] = 0;
                max = Math.max(max, i - left);
            }

        }

        return max;
    }

    public static void main(String[] args) {
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("apple", "苹果");
//        map.put("watermelon", "西瓜");
//        map.put("banana", "香蕉");
//        map.put("peach", "桃子");
//
//        map.get("banana");
//        map.get("apple");
//
//        Iterator iterator = map.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        map.get("banana");
        map.get("apple");
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}