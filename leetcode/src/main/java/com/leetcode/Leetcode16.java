package com.leetcode;

import java.util.Arrays;

public class Leetcode16 {

    public static void main(String[] args) {
        Leetcode16 leetcode16 = new Leetcode16();
        System.out.println(leetcode16.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; ++i){
            for(int j = i+1; j < nums.length-1; ++j){
                int val = target - nums[i] - nums[j];
                if(val < nums[j]){
                    break;
                }
                int res = findCloest(nums, j+1, val);
                if(Math.abs(nums[i] + nums[j] + res - target) < Math.abs(ans - target)){
                    ans = nums[i] + nums[j] + res;
                }
            }
        }
        return ans;
    }

    private int findCloest(int[] nums, int begin, int val){
        int r = nums.length - 1;
        int l = begin;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] < val){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(l > begin && Math.abs(nums[l-1] - val) < Math.abs(nums[l] - val)){
            return nums[l-1];
        }else{
            return nums[l];
        }
    }

}
