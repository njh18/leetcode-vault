package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return new ListNode();
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode headNode; // return value
        ListNode pointerNode;
        ListNode list1Pointer = list1;
        ListNode list2Pointer = list2;

        if (list1.val <= list2.val) {
            headNode = list1;
            list1Pointer = list1.next;
            pointerNode = list1;
        } else {
            headNode = list2;
            list2Pointer = list2.next;
            pointerNode = list2;
        }

        while (list1Pointer != null || list2Pointer != null) {
            if (list1Pointer == null) {
                pointerNode.next = list2Pointer;
                list2Pointer = list2Pointer.next;
                pointerNode = pointerNode.next;
                continue;
            }
            if (list2Pointer == null) {
                pointerNode.next = list1Pointer;
                list1Pointer = list1Pointer.next;
                pointerNode = pointerNode.next;
                continue;
            }
            if (list1Pointer.val <= list2Pointer.val) {
                pointerNode.next = list1Pointer;
                list1Pointer = list1Pointer.next;
            } else {
                pointerNode.next = list2Pointer;
                list2Pointer = list2Pointer.next;
            }
            pointerNode = pointerNode.next;
        }
        return headNode;
    }
}
