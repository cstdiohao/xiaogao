package com.leetcode;

public class Leetcode567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] nums = new int[26];
        for(int i = 0; i < s1.length(); i++){
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--;
        }
        if(check(nums)){
            return true;
        }
        for(int i = s1.length(); i < s2.length(); i++){
            nums[s2.charAt(i) - 'a']--;
            nums[s2.charAt(i - s1.length()) - 'a']++;
            if(check(nums)){
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] nums){
        for(int i = 0; i < 26; i++){
            if(nums[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode567 leetcode567 = new Leetcode567();
        System.out.println(leetcode567.checkInclusion("ab", "eidbaooo"));
        System.out.println(leetcode567.checkInclusion("ab", "eidboaoo"));
        System.out.println(leetcode567.checkInclusion("abccef", "fcdicafebcid"));
        System.out.println(leetcode567.checkInclusion("abc", "bca"));
        System.out.println(leetcode567.checkInclusion("abc", "bbc"));
        System.out.println(leetcode567.checkInclusion("abc", "n"));
    }

}
