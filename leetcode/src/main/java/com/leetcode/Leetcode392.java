package com.leetcode;

public class Leetcode392 {
    public static void main(String[] args) {
        Leetcode392 leetcode392 = new Leetcode392();
        System.out.println(leetcode392.isSubsequence("abc", "ahbgdc"));
        System.out.println(leetcode392.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            while(index < t.length()){
                if(s.charAt(i) == t.charAt(index++)){
                    break;
                }
            }
            if(index == t.length() && (i != s.length() - 1 || s.charAt(s.length()-1) != t.charAt(t.length()-1))){
                return false;
            }
        }
        return true;
    }

}
