package com.smartershining;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by smartershining on 16-6-16.
 */
class TrieNode2 {
    public TrieNode2[] children = new TrieNode2[26];
    public String item = "";
}

public class Findwords {
    class Trie {
        public TrieNode2 root = new com.smartershining.TrieNode2();

        public void insert(String word) {
            TrieNode2 node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode2();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word) {
            TrieNode2 node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            if (node.item.equals(word)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean startWith(String word) {
            TrieNode2 node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }

        Set<String> result = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            List<String> list = new ArrayList<>();
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            int m = board.length;
            int n = board[0].length;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, visited, "", i, j, trie);
                }
            }
            return new ArrayList<String>(result);
        }

        public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
            int m = board.length;
            int n = board[0].length;

            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            str = str + board[i][j];
            if (!trie.startWith(str)) {
                return;
            }
            if (trie.search(str)) {
                result.add(str);
            }
            visited[i][j] = true;
            dfs(board, visited, str, i + 1, j, trie);
            dfs(board, visited, str, i - 1, j, trie);
            dfs(board, visited, str, i, j + 1, trie);
            dfs(board, visited, str, i, j - 1, trie);
            visited[i][j] = false;

        }

    }

}
