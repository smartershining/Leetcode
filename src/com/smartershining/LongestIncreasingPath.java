package com.smartershining;

/**
 * Created by smartershining on 16-8-7.
 */

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2:
 * <p>
 * nums = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPath {
    int longest = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                helper(matrix, i, j, 1);
            }
        }
        return longest;
    }

    public void helper(int[][] matrix, int i, int j, int len) {
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            longest = Math.max(longest, len + 1);
            helper(matrix, i - 1, j, len + 1);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            longest = Math.max(longest, len + 1);
            helper(matrix, i + 1, j, len + 1);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            longest = Math.max(longest, len + 1);
            helper(matrix, i, j - 1, len + 1);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            longest = Math.max(longest, len + 1);
            helper(matrix, i, j + 1, len + 1);
        }

    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] mem = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, mem));
            }
        }
        return longest;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] mem) {

        if (mem[i][j] != 0) {
            return mem[i][j];
        }


        mem[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                mem[i][j] = Math.max(mem[i][j], dfs(matrix, x, y, mem) + 1);
            }
        }
        return mem[i][j];
    }

}
