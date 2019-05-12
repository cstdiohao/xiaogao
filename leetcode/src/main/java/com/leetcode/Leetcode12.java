package com.leetcode;

public class Leetcode12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        StringBuilder sb = new StringBuilder();
        for(int i = 0; num > 0; ++i){
            int x = num % 10;
            if(x == 4){
                sb.append(roman[2*i+1]).append(roman[2*i]);
            }else if(x == 9){
                sb.append(roman[2*i+2]).append(roman[2*i]);
            }else if(x < 5){
                for(int j = 0; j < x; ++j){
                    sb.append(roman[2*i]);
                }
            }else{
                for(int j = 0; j < x - 5; ++j){
                    sb.append(roman[2*i]);
                }
                sb.append(roman[2*i+1]);
            }
            num /= 10;
        }
        return sb.reverse().toString();
    }

}
