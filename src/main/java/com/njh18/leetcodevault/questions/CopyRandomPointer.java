package com.njh18.leetcodevault.questions;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node,Node> oldNewMapping = new HashMap<>();
        Node oldCurrNode = head;
        while (oldCurrNode != null) {
            oldNewMapping.put(oldCurrNode, new Node(oldCurrNode.val));
            oldCurrNode = oldCurrNode.next;
        }
        oldCurrNode = head;
        while (oldCurrNode != null) {
            Node newCurrNode = oldNewMapping.get(oldCurrNode);

            if (oldCurrNode.next != null) {
                newCurrNode.next = oldNewMapping.get(oldCurrNode.next);
            }

            if (oldCurrNode.random != null) {
                newCurrNode.random = oldNewMapping.get(oldCurrNode.random);
            }
            oldCurrNode = oldCurrNode.next;
        }
        return oldNewMapping.get(head);
    }
}
