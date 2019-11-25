package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        dfs(digits, 0, "", ans);
        return ans;
    }

    private void dfs(String digits, int index, String tem, List<String> ans){
        if(index == digits.length()){
            if(index != 0) {
                ans.add(tem);
            }
            return;
        }
        int begin, num;
        if(digits.charAt(index) == '9' || digits.charAt(index) == '7'){
            num = 4;
        }else{
            num = 3;
        }
        if(digits.charAt(index) > '7'){
            begin = 1;
        }else{
            begin = 0;
        }
        for(int i = begin; i < begin + num; ++i){
            tem += (char)((digits.charAt(index) - '2') * 3 + i + 'a');
            dfs(digits, index + 1, tem, ans);
            tem = tem.substring(0, index);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode17().letterCombinations("89"));
    }

}
