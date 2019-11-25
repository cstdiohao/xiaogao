package com.leetcode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Leetcode102 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public class QueueNode{
        TreeNode treeNode;
        int depth;
        QueueNode(TreeNode treeNode, int depth){
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root != null) {
            bfs(ans, root);
        }
        return ans;
    }

    private void bfs(List<List<Integer>> ans, TreeNode root){
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.add(new QueueNode(root, 0));
        while(!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            if(ans.size() <= queueNode.depth){
                ans.add(new ArrayList<Integer>());
            }
            List list = ans.get(queueNode.depth);
            list.add(queueNode.treeNode.val);
            if(queueNode.treeNode.left != null){
                queue.add(new QueueNode(queueNode.treeNode.left, queueNode.depth + 1));
            }
            if(queueNode.treeNode.right != null){
                queue.add(new QueueNode(queueNode.treeNode.right, queueNode.depth + 1));
            }
        }
    }

}
