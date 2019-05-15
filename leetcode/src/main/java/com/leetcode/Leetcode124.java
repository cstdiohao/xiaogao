package com.leetcode;

public class Leetcode124 {

    int ans;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        search(root);
        return ans;
    }

    private int search(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = search(node.left);
        int r = search(node.right);
        int tem = Math.max(Math.max(l, r) + node.val, Math.max(node.val, l + r + node.val));
        ans = Math.max(ans, tem);
        return Math.max(node.val, Math.max(l, r) + node.val);
    }




  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
