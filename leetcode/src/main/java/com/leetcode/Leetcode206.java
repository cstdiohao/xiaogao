package com.leetcode;

public class Leetcode206 {
     public class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
         }
     }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = null;
        while(second != null){
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        head.next = null;
        return first;
    }

}
