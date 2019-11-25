package com.leetcode;

public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len + 5];
        ans[0] = nums[0];
        int max = ans[0];
        for(int i = 1; i < len; ++i){
            ans[i] = ans[i - 1] < 0 ? nums[i] : ans[i - 1] + nums[i];
            max = Math.max(max, ans[i]);
        }
        return max;
    }

}
