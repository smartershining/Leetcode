package com.smartershining;

/**
 * Created by smartershining on 16-4-25.
 */
public class NumIslands {

    private int n, m;

    void dfs(char[][] grid, int x, int y) {
        if (x >= n || x < 0 || y >= m || y < 0) return;
        if (grid[x][y] != '1') return;
        grid[x][y] = '2';
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] c = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        NumIslands numIsland = new NumIslands();
        System.out.println(numIsland.numIslands(c));

    }
}
