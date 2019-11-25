package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List[][] cache;

    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<TreeNode>();
        }
        cache = new ArrayList[n+2][n+2];
        return getTree(1, n);
    }

    private List<TreeNode> getTree(int begin, int end){
        if(cache[begin][end] != null){
            return cache[begin][end];
        }
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(begin > end){
            nodes.add(null);
            return nodes;
        }
        for(int i = begin; i <= end; i++){
            List<TreeNode> leftNodes = getTree(begin, i - 1);
            List<TreeNode> rightNodes = getTree(i + 1, end);
            for(TreeNode leftNode : leftNodes){
                for(TreeNode rightNode : rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    nodes.add(root);
                }
            }
        }
        cache[begin][end] = nodes;
        return nodes;
    }

    public static void main(String[] args) {
        Leetcode95 leetcode95 = new Leetcode95();
        System.out.println(leetcode95.generateTrees(0));
    }

}
