package com.smartershining;

/**
 * Created by smartershining on 16-4-30.
 */
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        return dfs(0, 0, grid);

    }

    public static int dfs(int x, int y, int[][] grid) {
        if (x == grid.length && y == grid[0].length)
            return grid[x][y];
        if (x < grid.length && y < grid[0].length) {
            int r1 = grid[x][y] + dfs(x + 1, y, grid);
            int r2 = grid[x][y] + dfs(x, y + 1, grid);
            return Math.min(r1, r2);
        }
        if (x < grid.length) {
            return grid[x][y] + dfs(x + 1, y, grid);
        }
        if (y < grid[0].length) {
            return grid[x][y] + dfs(x, y + 1, grid);
        }
        return 0;
    }

    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1])
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                else
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {1, 1}};


    }
}
