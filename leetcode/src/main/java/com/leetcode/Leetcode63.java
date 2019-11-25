package com.leetcode;

public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1){
            return 0;
        }
        int[][] ans = new int[n][m];
        ans[0][0] = 1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                if(i != 0){
                    ans[i][j] += ans[i-1][j];
                }
                if(j != 0){
                    ans[i][j] += ans[i][j-1];
                }
            }
        }
        return ans[n-1][m-1];
    }

}
