package com.leetcode;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.jump(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[len-1] = 0;
        for(int i = len-2; i>=0; --i){
            ans[i] = len;
            if(nums[i] >= len-1-i){
                ans[i] = 1;
            }else{
                for(int j = 0; j < nums[i]; ++j){
                    ans[i] = Math.min(ans[i], ans[i+j+1]+1);
                }
            }
        }
        return ans[0];
    }

}
