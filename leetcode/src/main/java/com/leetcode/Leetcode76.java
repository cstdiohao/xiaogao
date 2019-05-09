package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Leetcode76 {

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
//        System.out.println(leetcode76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetcode76.minWindow("AACF", "CFAA"));
    }

    public String minWindow(String s, String t) {
        String ans = "";
        int minLen = s.length() + 1;
        int left = 0;
        Map<Character, Integer> charNum = new HashMap();
        for(int i = 0; i < t.length(); ++i){
            Integer num = charNum.get(t.charAt(i));
            if(num == null){
                num = 0;
            }
            charNum.put(t.charAt(i), ++num);
        }
        int len = t.length();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(charNum.containsKey(c)){
                int num = charNum.get(c);
                charNum.put(c, --num);
                if(num >= 0){
                    len--;
                }
                if(len == 0){
                    while(left <= i){
                        if(!charNum.containsKey(s.charAt(left))){
                            left++;
                        }else{
                            int tem = charNum.get(s.charAt(left));
                            if(tem < 0){
                                charNum.put(s.charAt(left), ++tem);
                                ++left;
                            }else{
                                break;
                            }
                        }
                    }
                    if(minLen > i - left + 1){
                        minLen = i - left + 1;
                        ans = s.substring(left, i+1);
                    }
                }
            }
        }

        return ans;
    }

}
