package com.leetcode;

public class Leetcode135 {

    public static void main(String[] args) {
        Leetcode135 leetcode135 = new Leetcode135();
        int[] ratings = new int[]{1,2,87,87,87,2,1};
        System.out.println(leetcode135.candy(ratings));
    }

    public int candy(int[] ratings) {

        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        for(int i = 1; i < len; ++i){
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 0;
        }
        right[len - 1] = 0;
        for(int i = len - 2; i >= 0; --i){
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 0;
        }
        int ans = 0;
        for(int i = 0; i < len; ++i){
            ans += Math.max(left[i], right[i]);
        }
        return ans + len;
    }

}
