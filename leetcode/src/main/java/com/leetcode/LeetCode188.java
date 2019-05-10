package com.leetcode;

public class LeetCode188 {

    public static void main(String[] args) {
        LeetCode188 leetCode188 = new LeetCode188();
        int[] a = new int[]{3,2,6,5,0,3};
        int[] b = new int[]{2,4,1};
        System.out.println(leetCode188.maxProfit(2, a));
        System.out.println(leetCode188.maxProfit(2, b));

    }


    public int maxProfit(int k, int[] prices) {
        k = Math.min(k, prices.length / 2 + 1);
        int[][] buy = new int[prices.length][2];
        int[][] sell = new int[prices.length][2];
        int ans = 0;
        for(int i = 0; i < k; ++i){
            int index = i & 1;
            for(int j = 0; j < prices.length; ++j){
                if(j != 0) {
                    buy[j][index] = Math.max(buy[j - 1][index], sell[j - 1][1 - index] - prices[j]);
                    sell[j][index] = Math.max(sell[j-1][index], buy[j-1][index] + prices[j]);
                }else{
                    buy[j][index] = -prices[j];
                }
                ans = Math.max(ans, sell[j][index]);
            }
        }
        return ans;
    }

}
