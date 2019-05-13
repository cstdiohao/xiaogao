package com.leetcode;

public class Leetcode132 {

    public static void main(String[] args) {
        Leetcode132 leetcode132 = new Leetcode132();
        System.out.println(leetcode132.minCut("aab"));
        System.out.println(leetcode132.minCut("cddc"));
    }

    public int minCut(String s) {
        int[] ans = new int[s.length()+2];
        ans[0] = 1;
        boolean[] flag = new boolean[s.length()+2];
        for(int i = 1; i < s.length(); ++i){
            ans[i] = ans[i-1] + 1;
            for(int j = 1; j < i; ++j){
                if(flag[j] && s.charAt(j-1) == s.charAt(i)){
                    ans[i] = Math.min(ans[i], (j > 1 ? ans[j-2] : 0) + 1);
                    flag[j-1] = true;
                }
                flag[j] = false;
            }
            if(s.charAt(i) == s.charAt(i-1)){
                ans[i] = Math.min(ans[i], (i > 1 ? ans[i-2] : 0) + 1);
                flag[i-1] = true;
            }
            flag[i] = true;
        }
        return ans[s.length()-1] - 1;
    }

}
