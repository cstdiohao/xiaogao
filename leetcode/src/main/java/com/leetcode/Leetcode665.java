package com.leetcode;

public class Leetcode665 {

    public boolean checkPossibility(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        boolean isChanged = false;
        for(int i = 0; i < nums.length -1; i++){
            if(nums[i] > nums[i+1]){
                if(isChanged){
                    return false;
                }
                isChanged = true;
                if(i != 0){
                    if(nums[i+1] >= nums[i-1]){
                        nums[i] = nums[i+1];
                    }else{
                        nums[i+1] = nums[i];
                    }
                }
            }
        }
        return true;
    }


}
