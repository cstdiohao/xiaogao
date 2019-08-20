package com.leetcode;

public class Leetcode45 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,1,1};
        Leetcode45 leetcode45 = new Leetcode45();
        System.out.println(leetcode45.jump(nums));
    }

    public int jump(int[] nums) {
        return tan(nums, 0, 0);
    }

    private int tan(int[] nums, int position, int time){
        int len = nums.length;
        if(position == len-1){
            return time;
        }
        if(position + nums[position] >= len - 1){
            return time + 1;
        }
        int max = nums[position + 1] + 1;
        int nexPos = position + 1;
        for(int i = 2; i <= nums[position]; ++i){
            if(nums[position + i] + i > max){
                max = nums[position + i] + i;
                nexPos = position + i;
            }
        }
        return tan(nums, nexPos, time + 1);
    }

}
