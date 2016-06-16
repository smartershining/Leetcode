package com.smartershining;

import java.util.HashMap;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Implement a trie with insert, search, and startsWith methods.
 *  Note:
 *  You may assume that all inputs are consist of lowercase letters a-z.
 */

class TrieNode {
    boolean isLeaf;
    HashMap<Character, TrieNode> nexts;
    // Initialize your data structure here.
    public TrieNode() {
        nexts = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] s = word.toCharArray();
        TrieNode p = root;

        int i = 0;
        int n = word.length();

        while (i < n) {
            TrieNode next = p.nexts.get(s[i]);
            if (next != null) {
                p = next;
                i ++;
            } else {
                break;
            }
        }
        while (i < n) {
            TrieNode newTrie =  new TrieNode();
            p.nexts.put(s[i],newTrie);
            p = newTrie;
            i ++;
        }
        p.isLeaf = true;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            TrieNode child = p.nexts.get(word.charAt(i));
            if (child == null) {
                return false;
            }
            p = child;
        }
        return p.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); ++i) {
            TrieNode child = p.nexts.get(prefix.charAt(i));
            if (child == null) {
                return false;
            }
            p = child;
        }
        return true;
    }

}
