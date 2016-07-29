package com.smartershining;

import java.util.LinkedList;

/**
 * Created by smartershining on 16-7-29.
 */
public class SurroundedRegions {

    /**
     * 1. Depth-first Search
     * This solution causes java.lang.StackOverflowError, because for a large board,
     * too many method calls are pushed to the stack and causes the overflow.
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                merge(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                merge(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                merge(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                merge(board, n - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void merge1(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        merge1(board, i - 1, j);
        merge1(board, i + 1, j);
        merge1(board, i, j - 1);
        merge1(board, i, j + 1);
    }


    /**
     * 2. Breath-first Search
     */

    public void merge(char[][] board, int a, int b) {
        int m = board.length;
        int n = board[0].length;

        int index = a * n + b;
        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(index);
        board[a][b] = '#';
        while (!queue.isEmpty()) {
            int top = queue.poll();
            int i = top / n;
            int j = top % n;

            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = '#';
                queue.offer((i - 1) * m + j);
            }
            if (i + 1 < m && board[i + 1][j] == 'O') {
                board[i + 1][j] = '#';
                queue.offer((i + 1) * m + j);
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = '#';
                queue.offer(i * m + j - 1);
            }
            if (j + 1 < n && board[i][j + 1] == 'O') {
                board[i][j + 1] = '#';
                queue.offer(i * m + j + 1);
            }
        }

    }
}
