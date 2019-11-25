package com.poj;

import java.util.Scanner;

public class poj1088 {

    private static int a[][],b[][],n,m;
    private static int movex[] = new int[]{0, 1, 0, -1};
    private static int movey[] = new int[]{1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            n = input.nextInt();
            m = input.nextInt();
            int max = 0;
            a = new int[n+3][m+3];
            b = new int[n+3][m+3];
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= m; j++){
                    a[i][j] = input.nextInt();
                }
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    b[i][j] = dfs(i,j);
                    if(b[i][j] > max)
                        max = b[i][j];
                }
            }
            System.out.println(max);
        }
    }
    private static int dfs(int x, int y) {
        int max=0;
        if(x < 1 || y < 1 || x > n || y > m)
            return 0;
        if(b[x][y] > 0)
            return b[x][y];
        for(int i = 0; i < 4; ++i){
            int dx = x + movex[i];
            int dy = y + movey[i];
            if(dx > 0 && dy > 0 && dy <= n && dy <= n && a[x][y] > a[dx][dy]) {
                max = Math.max(max, dfs(dx, dy));
            }
        }
        b[x][y] = max + 1;
        return max+1;
    }

}
