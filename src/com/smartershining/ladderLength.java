package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-3-27.
 */
public class ladderLength {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
   if(wordList == null){
     return 0;
  }
    wordList.add(beginWord);
    wordList.add(endWord);

    HashSet<String> hash = new HashSet<String>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    hash.add(beginWord);

    int length = 1;
    while(!queue.isEmpty()){
      length ++ ;
      int size = queue.size();
      for(int i = 0; i < size; ++ i){
        String word = queue.poll();
        for(String nextWord:getNextWords(word,wordList)){
            if(hash.contains(nextWord)){
              continue;
            }
          if(nextWord.equals(endWord)){
            return  length;
          }
          hash.add(nextWord);
          queue.offer(nextWord);
        }
      }
    }
    return  0;
}
  public  ArrayList<String>  getNextWords(String word, Set<String> wordList){
    ArrayList<String> nextWords = new ArrayList<String>();
    for(char c = 'a' ; c < 'z' ; ++ c){
      for(int i = 0; i < word.length(); ++ i){
        if(c == word.charAt(i)){
          continue;
        }
        String nextWord = replace(word, i, c);
        if(wordList.contains(nextWord)){
          nextWords.add(nextWord);
        }
      }
    }
    return  nextWords;
  }

  public  String replace(String word, int i , char c){
    char [] chars = word.toCharArray();
    chars[i] = c;
    return  new String(chars);
  }

}
