package com.njh18.leetcodevault.questions.linkedlists;

import com.njh18.leetcodevault.model.ListNode;

import java.util.Stack;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        while(curr != null) {
            stack.add(curr);
            curr = curr.next;
        }
        ListNode prev = null;
        ListNode toBeRemoved = null;
        for (int i = 1; i <= n; i++) {
            prev = toBeRemoved;
            toBeRemoved = stack.pop();
        }

        if (stack.isEmpty()) {
            return prev;
        } else {
            ListNode front = stack.peek();
            front.next = prev;
            return head;
        }
    }
}
