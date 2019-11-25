package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Leetcode1172 {

    public static class DinnerPlates {
        private int cap;
        private int size;
        private List<Stack<Integer>> stacks;
        private PriorityQueue<Integer> notFullPriorityQueue;
        private PriorityQueue<Integer> notEmptyPriorityQueue;

        public DinnerPlates(int capacity) {
            cap = capacity;
            size = 1;
            stacks = new ArrayList<>();
            stacks.add(new Stack());
            notFullPriorityQueue = new PriorityQueue<>();
            notFullPriorityQueue.add(0);
            notEmptyPriorityQueue = new PriorityQueue<>(8, (a, b) -> b - a);
        }

        public void push(int val) {
            int index = notFullPriorityQueue.peek();
            Stack<Integer> stack = stacks.get(index);
            stack.push(val);
            if (stack.size() == 1) {
                notEmptyPriorityQueue.add(index);
            }
            if (stack.size() == cap) {
                notFullPriorityQueue.remove(index);
                stacks.add(new Stack());
                notFullPriorityQueue.add(size++);
            }
        }

        public int pop() {
            Integer index = notEmptyPriorityQueue.peek();
            if (index == null) {
                return -1;
            }
            Stack<Integer> stack = stacks.get(index);
            int val = stack.pop();
            if (stack.size() == cap - 1) {
                notFullPriorityQueue.add(index);
            }
            if (stack.size() == 0) {
                notEmptyPriorityQueue.remove(index);
            }
            return val;
        }

        public int popAtStack(int index) {
            if (stacks.size() <= index) {
                return -1;
            }
            Stack<Integer> stack = stacks.get(index);
            if (stack.size() == 0) {
                return -1;
            }
            int val = stack.pop();
            if (stack.size() == cap - 1) {
                notFullPriorityQueue.add(index);
            }
            if (stack.size() == 0) {
                notEmptyPriorityQueue.remove(index);
            }
            return val;
        }

        public static void main(String[] args) {
            DinnerPlates D = new DinnerPlates(2);
            D.push(1);
            D.push(2);
            D.push(3);
            D.push(4);
            D.push(5);
            D.popAtStack(1);
            D.push(4);
//            D.popAtStack(0);
//            D.push(20);
//            D.push(21);
//            D.popAtStack(0);
//            D.popAtStack(2);
//            D.pop();
//            D.pop();
//            D.pop();
//            D.pop();
//            D.pop();
        }

    }
}
