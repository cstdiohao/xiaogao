package com.leetcode;

import java.util.Arrays;

public class Leetcode455 {

    public static void main(String[] args) {
        Leetcode455 leetcode455 = new Leetcode455();
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        System.out.println(leetcode455.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int pos = 0;
        for(int i = 0; i < g.length; ++i){
            while(pos < s.length && s[pos] < g[i]){
                ++pos;
            }
            if(pos == s.length){
                break;
            }else{
                ++ans;
                ++pos;
            }
        }
        return ans;
    }

}
