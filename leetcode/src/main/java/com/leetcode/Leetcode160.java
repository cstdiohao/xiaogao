package com.leetcode;

import java.util.HashSet;

public class Leetcode160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode node = headA;
        while(node != null){
            nodeSet.add(node);
            node = node.next;
        }
        node = headB;
        while(node != null && !nodeSet.contains(node)){
            node = node.next;
        }
        return node;
    }

}
