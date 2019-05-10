package com.leetcode;

public class Leetcode97 {

    public static void main(String[] args) {
        Leetcode97 leetcode97 = new Leetcode97();
        System.out.println(leetcode97.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(leetcode97.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        if(s2.length() == 0){
            return s1.equals(s3);
        }
        int[][] res = new int[s1.length()+1][s2.length()+1];
        return solve(s1, s2, s3, 0, 0, res);
    }

    private boolean solve(String s1, String s2, String s3, int index1, int index2, int[][] res){
        if(res[index1][index2] != 0){
            return res[index1][index2] == 1;
        }
        if(index1 == s1.length() && index2 == s2.length()){
            res[index1][index2] = 1;
            return true;
        }
        res[index1][index2] = -1;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2) && solve(s1, s2, s3, index1+1, index2, res)){
            res[index1][index2] = 1;
            return true;
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2) && solve(s1, s2, s3, index1, index2+1, res)){
            res[index1][index2] = 1;
            return true;
        }
        return false;
    }

}
