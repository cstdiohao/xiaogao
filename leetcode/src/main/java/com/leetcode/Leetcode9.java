package com.leetcode;

public class Leetcode9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        while(x > 0){
            sb.append((char)('0' + x%10));
            x /= 10;
        }
        for(int i = 0; i < sb.length() / 2; ++i){
            if(sb.charAt(i) == sb.charAt(sb.length() - i - 1)){
                continue;
            }
            return false;
        }
        return true;
    }

}
