package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        K++;
        int ans = Integer.MAX_VALUE;
        int[][] dis = new int[K+1][n+1];
        for(int i = 0; i <= K; ++i){
            for(int j = 0; j <= n; j++)
            dis[i][j] = Integer.MAX_VALUE;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        for(int i = 0; i < flights.length; i++){
            Map tem = map.get(flights[i][0]);
            if(tem == null){
                tem = new HashMap();
            }
            tem.put(flights[i][1], flights[i][2]);
            map.put(flights[i][0], tem);
        }
        dis[0][src] = 0;
        for(int i = 0; i < K; i++){
            for(int j = 0; j < n; j++) if(dis[i][j] != Integer.MAX_VALUE){
                Map<Integer, Integer> tem = map.get(j);
                if(tem == null) continue;
                for(Map.Entry<Integer, Integer> entry : tem.entrySet()){
                    dis[i+1][entry.getKey()] = Math.min(dis[i+1][entry.getKey()], dis[i][j] + entry.getValue());
                }
            }
        }
        for(int i = 0; i <= K; i++){
            ans = Math.min(ans, dis[i][dst]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Leetcode787 leetcode787 = new Leetcode787();
        System.out.println(leetcode787.findCheapestPrice(3, new int[][]{{0,100,500},{0, 0, 100}, {0, 0, 0}}, 0, 2, 1));
    }

}
