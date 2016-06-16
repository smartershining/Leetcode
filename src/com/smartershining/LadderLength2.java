package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-6-5.
 */

class WordNode {
    String word;
    int step;

    public WordNode(String word, int step) {
        this.word = word;
        this.step = step;
    }
}

public class LadderLength2 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        wordList.add(endWord);

        while (!queue.isEmpty()) {
            WordNode top = queue.pop();
            String word = top.word;
            if (word.equals(endWord)) {
                return top.step;
            }
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = chars[i];
                    if (c != temp) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (wordList.contains(newWord)) {
                            queue.add(new WordNode(newWord, top.step + 1));
                            wordList.remove(newWord);
                        }
                        chars[i] = temp;
                    }
                }
            }
        }
        return 0;

    }


}
