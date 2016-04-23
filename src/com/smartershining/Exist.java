package com.smartershining;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 *  Given a 2D board and a word, find if the word exists in the grid.

 *  The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
 *  vertically neighboring. The same letter cell may not be used more than once.

 * For example,
 * Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean[][] map = new boolean[height][width];

        for(int i = 0;  i < height; ++ i){
            for(int j = 0; j < width; ++j){
                if(search(board,word,i,j,map,0))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word,int x, int y, boolean[][] map, int index){
        if(board[x][y] != word.charAt(index)){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }

        map[x][y] = true;
        int height = board.length;
        int width = board[0].length;

        if(y < width  - 1 && ! map[x][y + 1] && search(board,word,x , y + 1, map, index + 1) ){
            return true;
        }
        if(y > 0 && !map[x][y-1] && search(board,word,x,y-1,map,index+1)){
            return true;
        }
        if(x < height - 1 && !map[x + 1][y] && search(board,word,x+1,y,map,index+1)){
            return true;
        }
        if(x > 0 && !map[x - 1][y] && search(board,word,x-1,y,map,index+1)){
            return true;
        }
        map[x][y] = false;
        return false;

    }
}
