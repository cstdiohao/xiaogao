package com.leetcode;

public class Leetcode304 {
    int[][] sum;

    public Leetcode304(int[][] matrix) {
        if(matrix.length > 0) {
            sum = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                int cowSum = 0;
                for(int j = 0; j < matrix[0].length; j++){
                    cowSum += matrix[i][j];
                    sum[i][j] = cowSum;
                    if(i != 0){
                        sum[i][j] += sum[i-1][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sum[row2][col2];
        if(col1 > 0){
            ans -= sum[row2][col1 - 1];
        }
        if(row1 > 0){
            ans -= sum[row1 - 1][col2];
        }
        if(col1 > 0 && row1 > 0){
            ans += sum[row1 - 1][col1 - 1];
        }
        return ans;
    }



}
