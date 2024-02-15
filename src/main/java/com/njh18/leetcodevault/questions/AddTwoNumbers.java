package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode pointer = dummyNode;
        int combinedVal;
        int digitVal;
        int nextVal = 0;

        while (currL1 != null || currL2 != null) {
            if (currL1 != null && currL2 != null) {
                combinedVal = currL1.val + currL2.val + nextVal;
                digitVal = combinedVal % 10;
                nextVal = combinedVal / 10;
                pointer.next = new ListNode(digitVal);
                pointer = pointer.next;
                currL1 = currL1.next;
                currL2 = currL2.next;
                continue;
            }
            if (currL2 != null) {
                combinedVal = currL2.val + nextVal;
                digitVal = combinedVal % 10;
                nextVal = combinedVal / 10;
                pointer.next = new ListNode(digitVal);
                pointer = pointer.next;
                currL2 = currL2.next;
                continue;
            }
            // for currL1 != null
            combinedVal = currL1.val + nextVal;
            digitVal = combinedVal % 10;
            nextVal = combinedVal / 10;
            pointer.next = new ListNode(digitVal);
            pointer = pointer.next;
            currL1 = currL1.next;
        }
        if (nextVal != 0) {
            pointer.next = new ListNode(nextVal);
        }
        return dummyNode.next;
    }
}
