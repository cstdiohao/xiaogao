package com.leetcode;

public class Leetcode397 {

    public int integerReplacement(int n) {
        long x = 1;
        int ans = 0;
        while(x < n){
            x <<= 1;
            ans++;
        }
        if(x == n){
            return ans;
        }
        return Math.min(ans + slo(x-n), ans + slo(n-x/2) - 1);
    }

    private int slo(long n){
        if(n == 0){
            return 0;
        }
        int x = 1;
        while(x < n){
            x <<= 1;
        }
        if(x == n){
            return 1;
        }

        return Math.min(slo(x-n), slo(n-x/2)) + 1;
    }

    public static void main(String[] args) {
        Leetcode397 leetcode397 = new Leetcode397();
//        System.out.println(leetcode397.integerReplacement(8));
        System.out.println(leetcode397.integerReplacement(2147483647));
    }

}
