package com.leetcode;

public class Leetcode402 {

    public static void main(String[] args) {
        Leetcode402 leetcode402 = new Leetcode402();
        System.out.println(leetcode402.removeKdigits("1432219", 3));
        System.out.println(leetcode402.removeKdigits("10200", 1));
        System.out.println(leetcode402.removeKdigits("1", 1));

    }

    public String removeKdigits(String num, int k) {
        String ans = "" + num.charAt(0);
        int pos = 1;
        while(k > 0 && pos < num.length()){
            while(k > 0 && ans.length() > 0 && (num.charAt(pos) < ans.charAt(ans.length() - 1))){
                ans = ans.substring(0, ans.length() - 1);
                k--;
            }
            ans += num.charAt(pos);
            pos++;
        }
        if(pos != num.length()){
            ans += num.substring(pos);
        }
        if(k != 0){
            ans = ans.substring(0, ans.length() - k);
        }
        int begin = 0;
        while(begin < ans.length() && ans.charAt(begin) == '0'){
            begin++;
        }
        return begin == ans.length() ? "0" : ans.substring(begin);
    }


}
