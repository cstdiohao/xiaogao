package com.leetcode;

public class Leetcode85 {

    public static void main(String[] args) {
        Leetcode85 leetcode85 = new Leetcode85();
        char[][] m = {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                        };
        System.out.println(leetcode85.maximalRectangle(m));
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0){
            return 0;
        }

        int[][] max = new int[n][m];
        for(int i = 0; i < n; ++i){
            if(matrix[i][m-1] == '0'){
                max[i][m-1] = -1;
            }else{
                max[i][m-1] = m-1;
            }
            for(int j = m-2; j >=0; --j){
                if(matrix[i][j] == '0'){
                    max[i][j] = -1;
                }else{
                    max[i][j] = Math.max(max[i][j+1], j);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int minValue = Integer.MAX_VALUE;
                for(int k = i; k < n; ++k){
                    if(matrix[k][j] == '0'){
                        break;
                    }
                    minValue = Math.min(minValue, max[k][j]);
                    ans = Math.max(ans, (k-i+1) * (minValue-j+1));
                }
            }
        }
        return ans;
    }

}
