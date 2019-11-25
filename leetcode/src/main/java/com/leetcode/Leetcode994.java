package com.leetcode;

import java.util.ArrayDeque;

public class Leetcode994 {
    int[] tox = new int[]{0, 1, 0, -1};
    int[] toy = new int[]{1, 0, -1, 0};
    class Node{
        int x;
        int y;
        int time;
        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int num = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    num++;
                }
                if(grid[i][j] == 2){
                    queue.add(new Node(i, j, 0));
                }
            }
        }
        int max = 0;
        while(!queue.isEmpty()){
            Node node = queue.pop();
            num--;
            max = node.time;
            System.out.println(node.x + " " + node.y + " " + node.time);
            for(int i = 0; i < tox.length; i++){
                int nextx = node.x + tox[i];
                int nexty = node.y + toy[i];
                if(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m && grid[nextx][nexty] == 1){
                    grid[nextx][nexty] = 2;
                    queue.add(new Node(nextx, nexty, node.time + 1));
                }
            }
        }
        if(num == 0){
            return max;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Leetcode994 leetcode994 = new Leetcode994();
        leetcode994.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }

}
