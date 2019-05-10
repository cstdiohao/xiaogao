package com.leetcode;

public class Leetcode72_redo {

    public static void main(String[] args) {
        Leetcode72_redo leetcode72 = new Leetcode72_redo();
//        System.out.println(leetcode72.minDistance("horse", "ros"));
//        System.out.println(leetcode72.minDistance("intention", "execution"));
//        System.out.println(leetcode72.minDistance("a", "a"));
//        System.out.println(leetcode72.minDistance("sea", "eat"));
        System.out.println(leetcode72.minDistance("sea", "ate"));

    }

    public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return word1.length();
        }
        int[][] ans = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word2.length(); ++i){
            ans[0][i] = i;
        }
        for(int i = 0; i <= word1.length(); ++i){
            ans[i][0] = i;
        }
        for(int i = 1; i <= word1.length(); ++i){
            for(int j = 1; j <= word2.length(); ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    ans[i][j] = ans[i - 1][j - 1];
                } else {
                    ans[i][j] = Math.min(ans[i - 1][j - 1], Math.min(ans[i - 1][j], ans[i][j - 1])) + 1;
                }
            }
        }
        return ans[word1.length()][word2.length()];
    }

}
