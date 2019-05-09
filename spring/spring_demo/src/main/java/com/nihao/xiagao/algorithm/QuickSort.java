package com.nihao.xiagao.algorithm;

public class QuickSort {

    public static<T extends Comparable> void quickSort(T[] a){
        sort(a, 0, a.length-1);
    }

    private static<T extends Comparable> void sort(T[] a, int begin, int end){
        if(begin >= end) return;
        int l = begin, r = end;
        T tem = a[l++];
        while(l <= r){
            if(a[l].compareTo(tem) < 0){
                a[l-1] = a[l];
                ++l;
                continue;
            }else{
                T x = a[l];
                a[l] = a[r];
                a[r--] = x;
                continue;
            }
        }
        a[r]=tem;
        sort(a, begin, r-1);
        sort(a, r+1, end);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{6,5,3,4,2,1};
        quickSort(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }

}
