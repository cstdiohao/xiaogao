package com.leetcode.mycode;

import java.util.Random;

public class ListQuickSort {
    static class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = Math.abs(random.nextInt()) % 20;
        Node head = null;
        Node tail = null;
        Node pre = null;
        for(int i = 0; i < n; i++){
            Node node = new Node(random.nextInt() % 100);
            if(head == null){
                head = node;
                pre = node;
            }else{
                pre.next = node;
                node.pre = pre;
                pre = node;
            }
        }
        tail = pre;

        for(Node node = head; node != null; node = node.next){
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

}
