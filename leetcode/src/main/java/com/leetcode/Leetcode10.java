package com.leetcode;

public class Leetcode10 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("ab", ".*c"));
    }

    public static boolean isMatch(String s, String p) {
        if("".equals(s)){
            if("".equals(p)) {
                return true;
            }else if(p.length() > 1 && p.charAt(1) == '*'){
                return isMatch(s, p.substring(2));
            }else{
                return false;
            }
        }
        if(p.length() == 0){
            return false;
        }

        if(s.charAt(0) == p.charAt(0)){
            if(p.length() > 1 && p.charAt(1) == '*'){
                if(isMatch(s, p.substring(2))){
                    return true;
                }
                int index = 0;
                while(index < s.length() && s.charAt(index) == s.charAt(0)){
                    if(isMatch(s.substring(index + 1), p.substring(2))){
                        return true;
                    }
                    ++index;
                }
                return false;
            }else{
                return isMatch(s.substring(1), p.substring(1));
            }
        }else if(p.charAt(0) == '.'){
            if(p.length() > 1 && p.charAt(1) == '*'){
                if(isMatch(s, p.substring(2))){
                    return true;
                }
                int index = 0;
                while(index < s.length()){
                    if(isMatch(s.substring(index + 1), p.substring(2))){
                        return true;
                    }
                    ++index;
                }
                return false;
            }else{
                return isMatch(s.substring(1), p.substring(1));
            }
        }else if(p.length() > 1 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2));
        }else{
            return false;
        }
    }

}
