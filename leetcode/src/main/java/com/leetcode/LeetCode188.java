package com.leetcode;

public class LeetCode188 {

    public static void main(String[] args) {
        LeetCode188 leetCode188 = new LeetCode188();
        int[] a = new int[]{3,2,6,5,0,3};
        int[] b = new int[]{};
        System.out.println(leetCode188.maxProfit(2, a));
    }


    public int maxProfit(int k, int[] prices) {
        int ans = 0;
        int len = prices.length;
        int[][] tem = new int[2][len];
        tem[0][0] = Integer.MIN_VALUE;
        k = Math.min(k, len/2+1);
        for(int ii = 1; ii <= k; ++ii){
            int i = ii%2;
            for(int j = 1; j < len; ++j){
                tem[i][j] = tem[i][j-1];
                for(int x = j-1; x >=1; --x){
                    int y = 0;
                    if(x != 0){
                        y = tem[1-i][x-1];
                    }
                    if(y == Integer.MIN_VALUE){
                        break;
                    }
                    tem[i][j] = Math.max(tem[i][j], y - prices[x] + prices[j]);
                }
                ans = Math.max(ans, tem[i][j]);
            }
        }
        return ans;
    }

}
