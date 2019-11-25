package com.leetcode;

public class Leetcode91 {

    public static void main(String[] args) {
        Leetcode91 leetcode91 = new Leetcode91();
//        System.out.println(leetcode91.numDecodings("12"));
//        System.out.println(leetcode91.numDecodings("226"));
        System.out.println(leetcode91.numDecodings("10201"));
    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        int[] ans = new int[len+1];
        ans[1] = ans[0] = 1;
        for(int i = 1; i < len; ++i){
            if(s.charAt(i) != '0') {
                ans[i+1] = ans[i];
            }
            if(s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1, i+1)) <= 26){
                ans[i+1] += ans[i-1];
            }
            if(ans[i+1] == 0){
                return 0;
            }
        }
        return ans[len];
    }

}
