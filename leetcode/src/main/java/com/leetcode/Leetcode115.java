package com.leetcode;

public class Leetcode115 {

    public static void main(String[] args) {
        Leetcode115 leetcode115 = new Leetcode115();
        System.out.println(leetcode115.numDistinct("rabbbit", "rabbit"));
        System.out.println(leetcode115.numDistinct("babgbag", "bag"));
        System.out.println(leetcode115.numDistinct("aaa", "aaa"));

    }

    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 == 0 || len2 == 0 || len1 < len2){
            return 0;
        }

        int[][] ans = new int[len2+2][2];
        for(int i = 0; i < len1; ++i){
            int index = i&1;
            for(int j = 0; j < len2; ++j){
                ans[j][index] = ans[j][1-index];
                if(s.charAt(i) == t.charAt(j)){
                    if(j != 0) {
                        ans[j][index] += ans[j-1][1-index];
                    }else{
                        ans[j][index]++;
                    }
                }else if(i==0 && s.charAt(i) == t.charAt(j)){
                    ans[j][index] = 1;
                }
            }
        }
        return ans[len2-1][(len1-1)&1];
    }

}
