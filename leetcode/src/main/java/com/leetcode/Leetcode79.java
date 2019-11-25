package com.leetcode;

public class Leetcode79 {
    private boolean[][] isVis;
    private int[] xx = new int[]{0,1,0,-1};
    private int[] yy = new int[]{1,0,-1,0};

    public boolean exist(char[][] board, String word) {
        isVis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int posx, int posy){
        if(index == word.length()-1){
            return true;
        }
        isVis[posx][posy] = true;
        for(int i = 0; i < 4; i++){
            int tox = posx + xx[i];
            int toy = posy + yy[i];
            if(tox >= 0 && tox < board.length && toy >= 0 && toy < board[0].length && !isVis[tox][toy] && board[tox][toy] == word.charAt(index + 1)){
                if(dfs(board, word, index + 1, tox, toy)){
                    return true;
                }
            }
        }
        isVis[posx][posy] = false;
        return false;
    }

}
