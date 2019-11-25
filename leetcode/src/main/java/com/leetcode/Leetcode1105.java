package com.leetcode;

public class Leetcode1105 {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int bookNum = books.length;
        int[] dp = new int[bookNum];
        for(int i = 0; i < bookNum; ++i){
            dp[i] = Integer.MAX_VALUE;
            int maxHeight = 0;
            int sumWeight = 0;
            int j = i;
            while(j >= 0){
                maxHeight = Math.max(maxHeight, books[j][1]);
                sumWeight += books[j][0];
                if(sumWeight > shelf_width){
                    break;
                }
                if(j == 0){
                    dp[i] = Math.min(dp[i], maxHeight);
                } else {
                    dp[i] = Math.min(dp[i], maxHeight + dp[j-1]);
                }
                --j;
            }
        }
        return dp[bookNum-1];
    }

    public static void main(String[] args) {
        Leetcode1105 leetcode1105 = new Leetcode1105();
        System.out.println(leetcode1105.minHeightShelves(new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));
    }

}
