package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode501 {
    List<Integer> ans = new ArrayList<>();
    int maxNum = 0;
    int num = 0;
    int preVal;

    public int[] findMode(TreeNode root) {
        midSearch(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void midSearch(TreeNode node){
        if(node == null){
            return;
        }
        midSearch(node.left);
        deal(node.val);
        midSearch(node.right);
    }

    private void deal(int val){
        if(maxNum == 0){
            num = 1;
            maxNum = 1;
            preVal = val;
            ans.add(val);
            return;
        }
        if(val == preVal){
            num++;
        }else{
            preVal = val;
            num = 1;
        }
        if(num > maxNum){
            maxNum = num;
            ans.clear();
            ans.add(val);
        }else if(num == maxNum){
            ans.add(val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(0);
        Leetcode501 leetcode501 = new Leetcode501();
        System.out.println(leetcode501.findMode(root));
    }

}
