package com.leetcode;

public class Leetcode62 {

    public static void main(String[] args) {
        Leetcode62 leetcode62 = new Leetcode62();
        System.out.println(leetcode62.uniquePaths(3, 2));
        System.out.println(leetcode62.uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m+1][n+1];
        ans[0][0] = 1;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(i != 0){
                    ans[i][j] += ans[i-1][j];
                }
                if(j != 0){
                    ans[i][j] += ans[i][j-1];
                }
            }
        }
        return ans[m-1][n-1];
    }

}
