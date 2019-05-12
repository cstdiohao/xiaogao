package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {

    public static void main(String[] args) {
        Leetcode15 leetcode15 = new Leetcode15();
//        System.out.println(leetcode15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(leetcode15.threeSum(new int[]{0,0,0,0}));
        System.out.println(leetcode15.threeSum(new int[]{3,0,-2,-1,1,2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            for(int j = i+1; j < nums.length - 1; ++j){
                int sum = nums[i] + nums[j];
                if(-sum < nums[j]){
                    break;
                }
                if(canfind(nums, -sum, j+1, nums.length-1)){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-sum);
                    ans.add(list);
                }
                while(j+1 < nums.length && nums[j] == nums[j+1]){
                    ++j;
                }
            }
            while(i + 1 < nums.length && nums[i+1] == nums[i]){
                ++i;
            }
        }
        return ans;
    }

    private boolean canfind(int[] nums, int val, int l, int r){
        int mid;
        while(l < r){
            mid = (l + r) / 2;
            if(nums[mid] == val){
                return true;
            }else if(nums[mid] < val){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return nums[l] == val;
    }

}
