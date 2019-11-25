package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode839 {
    int[] father;

    public int numSimilarGroups(String[] A) {
        int len = A.length;
        father = new int[len];
        for(int i = 0; i < len; ++i){
            father[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < len; ++i){
            for(int j = i+1; j < len; ++j){
                if(isSimilar(A[i], A[j])){
                    int fatheri = findf(i);
                    int fatherj = findf(j);
                    father[fatheri] = fatherj;
                }
            }
        }
        for(int i = 0; i < len; i++){
            set.add(findf(i));
        }

        return set.size();
    }

    private int findf(int i){
        int x = father[i] == i ? i : findf(father[i]);
        father[i] = x;
        return x;
    }

    private boolean isSimilar(String a, String b){
        int len = a.length();
        int diffNum = 0;
        Character diffc1 = null, diffc2 = null;
        for(int i = 0; i < len; i++){
            if(a.charAt(i) != b.charAt(i)){
                diffNum++;
                if(diffNum == 1){
                    diffc1 = a.charAt(i);
                    diffc2 = b.charAt(i);
                }else if(diffNum == 2){
                    if(a.charAt(i) != diffc2 || b.charAt(i) != diffc1){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode839 leetcode839 = new Leetcode839();
        System.out.println(leetcode839.numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    }

}
