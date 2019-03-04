package com.leetcode;

public class Leetcode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        long val = 0;
        int flag = 1;

        int i = 0;
        while(i < str.length() && str.charAt(i) == ' '){
            ++i;
        }
        if(i == str.length() || str.charAt(i) != '+' && str.charAt(i) != '-' && (str.charAt(i) < '0' || str.charAt(i) > '9')){
            return 0;
        }

        if(str.charAt(i) == '-'){
            flag = -1;
            ++i;
        }else if (str.charAt(i) == '+'){
            ++i;
        }

        while(i < str.length()){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            val = val * 10 + (str.charAt(i) - '0');
            ++i;
            if(val * flag > maxValue){
                return maxValue;
            }else if (val * flag < minValue){
                return minValue;
            }
        }
        return (int)val * flag;
    }

}
