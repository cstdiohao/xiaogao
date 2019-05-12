package com.leetcode;

import java.util.Stack;

public class Leetcode32 {

    public static void main(String[] args) {
        Leetcode32 leetcode32 = new Leetcode32();
        System.out.println(leetcode32.longestValidParentheses("()(()"));
        System.out.println(leetcode32.longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
        System.out.println(leetcode32.longestValidParentheses("())()()(())((()(()()(((()))((((())((()(())()())(()((((()))()(()))(())()(())(()(((((())((((((()())())(()(()((())()))(()))))))()(()))((((())()()()))()()()(((()(()())(()()(()(()()(((()))))))()()))())())((()()))))))((()))(((()((())()(()()))((())))()()())))))))()))))(()))))()))()))()((())))((()))(()))))))(((()))))))))()(()()()(())((())()))()()(())))()()))(()())()))(((()())()))((())((((()))(()(()(()()()(((())()(((((()))((()(((((())(()()))((((((((()(()(()(()(())))(())(()())())(()((((()(())((()(())))(())))()(((((()(()()(())))))))())(())(())(()()(((())))((()))(((((()))))())))()((()))()))))())))))((())(((((()()))((((())))(((()(()(())())(((()(()(()()()())))())()))((()((())())()()()(((())(((((()((((((()((()())))((((())((()(((((((()(()((()()()(()(()())(()(()()((((())))()(((()())))(()()))()(()()()()(((((())(()))))((()))())))()((((((()))())))()(()))(())))((((()())(((((()()())(((((())(()())(()))))()(()()))()))))))())))(((())(()(()()))(()))()(((())))())((((()(((()))))))()(()(()))()()(()()))))))))((()))))))(())((()((()))()))((((((()())))))(()((())((((()))))(()(()()()()(()))()()(()(()))(()()(((((((()())(())(()())((())())()(()())((())()())())(()())))())))(())())())(())((()())(((()()))()))()()))()(()(())((((((((())))()((())((()((((((((((()))))(()(((((())(()(()())())))((())())))))()))(()((()()))((()((())()()()((()(())())((())())(()()(((())))))())()()(()))()())(()(()((())))((((()()(())))())(())(()(()(())())())(()()())()(())())))(()()(((())))((()()(((())()()(()())((((()()(()())(()((((()(()()(()(()(((()((()())(()()))(()((((()(((((()))))()()))(((()((((((()(()()()()())()))(()(())))))((()(((()())())))(((()()))(()(()(((((((()()))(()(())))())()(())())(())(()))(())(()))()()(()()())))))()))()((())(((()((((((((())()()))())))((()())("));

    }

    public int longestValidParentheses(String s) {
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else if(stack.empty() || stack.peek().equals(')')){
                stack.push(s.charAt(i));
            }else if(stack.peek() instanceof Integer){
                int topVal = (Integer)stack.pop();
                if(stack.empty() || stack.peek().equals(')')){
                    stack.push(topVal);
                    stack.push(s.charAt(i));
                }else{
                    stack.pop();
                    if(!stack.empty() && stack.peek() instanceof Integer){
                        int secondVal = (Integer) stack.pop();
                        stack.push(topVal + secondVal + 2);
                    }else {
                        stack.push(topVal + 2);
                    }
                }
            }else{
                stack.pop();
                if(!stack.empty() && stack.peek() instanceof Integer){
                    int tolVal = (Integer) stack.pop();
                    stack.push(tolVal + 2);
                }else {
                    stack.push(2);
                }
            }
        }
        int ans = 0;
        while(!stack.empty()){
            Object obj = stack.pop();
            if(obj instanceof Integer){
                Integer val = (Integer) obj;
                ans = Math.max(ans, val);
            }
        }
        return ans;
    }

//    public int longestValidParentheses(String s) {
//        int[][] ans = new int[s.length()][s.length()];
//        boolean[][] isVis = new boolean[s.length()][s.length()];
//        for(int i = 0; i < s.length(); ++i){
//            for(int j = 0; j < s.length(); ++j){
//                ans[i][j] = -s.length();
//            }
//        }
//        int maxAns = 0;
//        for(int i = 0; i < s.length(); ++i){
//            for(int j = i+1; j < s.length(); ++j){
//                ans[i][j] = getAns(s, i, j, ans, isVis);
//                maxAns = Math.max(maxAns, ans[i][j]);
//            }
//        }
//        return maxAns;
//    }
//
//    private int getAns(String s, int l, int r, int[][]ans, boolean[][] isVis){
//        if(l > r){
//            return ans[l][r] = 0;
//        }
//        if(l == r || isVis[l][r]){
//            return ans[l][r];
//        }
//        isVis[l][r] = true;
//        if(s.charAt(l) == '(' && s.charAt(r) == ')'){
//            ans[l][r] = getAns(s, l+1, r-1, ans, isVis) + 2;
//        }
//        for(int i = l+1; i < r-1; ++i){
//            ans[l][r] = Math.max(ans[l][r], getAns(s, l, i, ans, isVis) + getAns(s, i+1, r, ans, isVis));
//        }
//        return ans[l][r];
//    }



}
