package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.ListNode;

import java.util.Stack;

public class ReOrderList {

    public void reorderList_bruteForce(ListNode head) {
        ListNode curr = head.next;
        Stack<ListNode> nodeStack = new Stack<>();
        while (curr != null) {
            nodeStack.push(curr);
            curr = curr.next;
        }

        int counter = 1;
        ListNode pointer = head;
        while (counter <= nodeStack.size()) {
            ListNode oldNext = pointer.next;
            ListNode newNext = nodeStack.pop();
            if (!oldNext.equals(newNext)) {
                pointer.next = newNext;
                newNext.next = oldNext;
            }
            pointer = oldNext;
            counter++;
        }
        pointer.next = null;
    }
}
