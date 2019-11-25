package com.leetcode;
//题目原来的意思是在一个字符串前面添加最少的字符，使这个字符串变成回文串
//我写的是，任意添加字符，使这个字符串变成回文串
public class Leetcode214_error {

    private String[][] ans;
    public String shortestPalindrome(String s) {
        ans = new String[s.length() + 2][s.length() + 2];
        return solve(s, 0, s.length()-1);
    }

    private String solve(String s, int begin, int end){
        if(begin > end){
            return "";
        }
        if(ans[begin][end] != null){
            return ans[begin][end];
        }
        if(begin == end){
            String str = s.substring(begin, end+1);
            ans[begin][end] = str;
            return str;
        }

        String str;
        if(s.charAt(begin) == s.charAt(end)) {
            str = s.charAt(begin) + solve(s, begin + 1, end - 1) + s.charAt(end);
        }else if(solve(s, begin, end-1).length() > solve(s, begin+1, end).length()){
            str = s.charAt(begin) + solve(s, begin+1, end) + s.charAt(begin);
        }else{
            str = s.charAt(end) + solve(s, begin, end-1) + s.charAt(end);
        }
        ans[begin][end] = str;
        return str;
    }

    public static void main(String[] args) {
        Leetcode214_error leetcode214 = new Leetcode214_error();
        System.out.println(leetcode214.shortestPalindrome(""));
    }

}
