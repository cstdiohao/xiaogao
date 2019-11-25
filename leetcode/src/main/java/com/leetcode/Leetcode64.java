package com.leetcode;

public class Leetcode64 {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                ans[i][j] = grid[i][j];
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    ans[i][j] += ans[i][j-1];
                } else if(j == 0){
                    ans[i][j] += ans[i-1][j];
                } else {
                    ans[i][j] += Math.min(ans[i-1][j], ans[i][j-1]);
                }
            }
        }
        return ans[n-1][m-1];
    }

    public int minPathSum1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        dfs(0, 0, ans, grid);
        return ans[n][m];
    }

    private int dfs(int i, int j, int[][] ans, int[][] grid){
        if(i >= ans.length || j >= ans[0].length){
            return Integer.MAX_VALUE;
        }
        if(ans[i][j] != 0){
            return ans[i][j];
        }

        ans[i][j] = grid[i][j];
        if(i != ans.length-1 || j != ans[0].length -1 ) {
            ans[i][j] += Math.min(dfs(i + 1, j, ans, grid), dfs(i, j + 1, ans, grid));
        }
        return ans[i][j];
    }



}
