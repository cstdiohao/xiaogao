package com.leetcode;

public class Leetcode14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; ++i){
            minLen = Math.min(minLen, strs[i].length());
        }
        for(int index = 0; index < minLen; ++index){
            char c = strs[0].charAt(index);
            for(int i = 1; i < strs.length; ++i){
                if(strs[i].charAt(index) != c){
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }

}
