package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Leetcode451 {
    public class CharNum{
        public CharNum(char c, int num){
            this.c = c;
            this.num = num;
        }
        public char c;
        public int num;
    }

    public String frequencySort(String s) {
        HashMap<Character, CharNum> charNumMap = new HashMap<>();
        List<CharNum> charNumList = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i){
            CharNum charNum = charNumMap.get(s.charAt(i));
            if(charNum == null){
                charNum = new CharNum(s.charAt(i), 0);
                charNumList.add(charNum);
            }
            charNum.num++;
            charNumMap.put(s.charAt(i), charNum);
        }
        Collections.sort(charNumList, (charNum1, charNum2) -> charNum2.num - charNum1.num);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charNumList.size(); i++){
            CharNum charNum = charNumList.get(i);
            for(int j = 0; j < charNum.num; j++){
                sb.append(charNum.c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode451 leetcode451 = new Leetcode451();
        System.out.println(leetcode451.frequencySort("hkg"));
    }

}
