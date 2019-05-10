package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode87_redo {

    public static void main(String[] args) {
        Leetcode87_redo leetcode87 = new Leetcode87_redo();
        System.out.println(leetcode87.isScramble("great", "rgeat"));
        System.out.println(leetcode87.isScramble("abc", "cba"));
        System.out.println(leetcode87.isScramble("abcd", "badc"));
        System.out.println(leetcode87.isScramble("oatzzffqpnwcxhejzjsnpmkmzngneo", "acegneonzmkmpnsjzjhxwnpqffzzto"));
    }

    private Map<String, Boolean> map = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
        String key = s1 + "*" + s2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(s1.length() != s2.length()){
            map.put(key, false);
            return false;
        }
        if(s1.equals(s2)){
            map.put(key, true);
            return true;
        }

        int len = s1.length();
        for(int i = 1; i < len; ++i){
            if(isScramble(s1.substring(0, i), s2.substring(len-i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len-i))
                    || isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))){
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;

    }

}
