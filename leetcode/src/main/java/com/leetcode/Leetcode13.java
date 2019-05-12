package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

    }

    public static int romanToInt(String s) {
        char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Map<Character, Integer> romanToIntMap = new HashMap<Character, Integer>();
        int val = 1;
        for(int i = 0; i < roman.length; ++i){
            romanToIntMap.put(roman[i++], val);
            val *= 5;
            if(i >= roman.length){
                break;
            }
            romanToIntMap.put(roman[i], val);
            val *= 2;
        }
        int ans = romanToIntMap.get(s.charAt(0));
        for(int i = 1; i < s.length(); ++i){
            if(romanToIntMap.get(s.charAt(i)) / romanToIntMap.get(s.charAt(i-1)) == 5 ||
                    romanToIntMap.get(s.charAt(i)) / romanToIntMap.get(s.charAt(i-1)) == 10){
                ans -= 2 * romanToIntMap.get(s.charAt(i -1));
            }
            ans += romanToIntMap.get(s.charAt(i));
        }
        return ans;
    }

}
