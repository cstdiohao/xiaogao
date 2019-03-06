package com.leetcode;

public class Leetcode11_good {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(height));

        height = new int[]{6,1,2,3,4,5,11,6};
        System.out.println(maxArea(height));
        System.out.println(maxArea1(height));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        boolean[] isMax = new boolean[len];
        int[] leftNextBigger = new int[len];
        int max = height[0];
        isMax[0] = true;
        leftNextBigger[0] = -1;

        for(int i = 1; i < len; ++i){
            if(height[i] > max){
                isMax[i] = true;
                max = height[i];
            }else{
                isMax[i] = false;
            }

            int index = i - 1;
            while(index > 0 && height[index] < height[i]){
                index = leftNextBigger[index];
            }
            leftNextBigger[i] = index;
        }

        int ans = -1;
        for(int i = 0; i < len; ++i){
            if(!isMax[i]){
                continue;
            }
            int right = len - 1;
            int temMax = -1;
            while(right > i){
                temMax = Math.max(temMax, Math.min(height[i], height[right]) * (right - i));
                right = leftNextBigger[right];
            }
            ans = Math.max(ans, temMax);
        }
        return ans;
    }

    //网上的方法
    public static int maxArea1(int[] height){
        int ans = -1, len = height.length;
        int l = 0, r = len - 1;
        while(l < r){
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
            if(height[l] > height[r]){
                --r;
            }else{
                ++l;
            }
        }
        return ans;
    }

    //想了一会，觉得自己

}
