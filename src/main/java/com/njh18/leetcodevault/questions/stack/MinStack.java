package com.njh18.leetcodevault.questions.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStack {

    public Stack<Integer> stack;
    public Map<Integer, Integer> minMap;

    public MinStack() {
        this.stack = new Stack<>();
        this.minMap = new HashMap<>();
    }

    public void push(int val) {
        stack.push(val);
        int currStackSize = stack.size();
        if (currStackSize == 1) {
            minMap.put(1, val);
        } else {
            int currMin = Math.min(
                    minMap.getOrDefault(stack.size() - 1, Integer.MAX_VALUE),
                    val
            );
            minMap.put(currStackSize, currMin);
        }
    }

    public void pop() {
        minMap.remove(stack.size());
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minMap.get(stack.size());
    }
}
