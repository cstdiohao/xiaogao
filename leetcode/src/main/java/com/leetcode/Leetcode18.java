package com.leetcode;

import java.util.*;

public class Leetcode18 {
    Set<String> isExist = new HashSet<String>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        isExist.clear();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tem = new ArrayList<Integer>();
        dfs(nums, target, 0, 0, 0, tem, ans);
        return ans;
    }

    private void dfs(int[] nums, int target, int num, int index, int sum, List<Integer> tem, List<List<Integer>> ans) {
        if (index >= nums.length) {
            return;
        }
        if (num == 3) {
            for (int i = index; i < nums.length; ++i) {
                if (sum + nums[i] == target) {
                    tem.add(nums[i]);
                    if (!isExist.contains(tem.toString())) {
                        ans.add(new ArrayList<Integer>(tem));
                        isExist.add(tem.toString());
                        tem.remove(tem.size() - 1);
                        return;
                    }
                    if (i + 1 < nums.length && sum + nums[i] < target && sum + nums[i + 1] > target) {
                        return;
                    }
                }
            }
            for (int i = index; i < nums.length; ++i) {
                tem.add(nums[i]);
                dfs(nums, target, num + 1, i + 1, sum + nums[i], tem, ans);
                tem.remove(tem.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> tem = Arrays.asList(1,2,2,4,6);
        System.out.println(tem.toString());
        Leetcode18 leetcode18 = new Leetcode18();
        System.out.println(leetcode18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
