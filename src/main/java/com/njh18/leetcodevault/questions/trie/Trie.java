package com.njh18.leetcodevault.questions.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    public class Node {
        Map<Character, Node> children;
        boolean isCompleteWord;

        public Node() {
            this.children = new HashMap<>();
            this.isCompleteWord = false;
        }
    }

    public Map<Character, Node> rootMap;

    public Trie() {
        rootMap = new HashMap<>();
    }

    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        Map<Character, Node> currMap = rootMap;
        Node currNode = new Node();
        for (Character c : word.toCharArray()) {
            currMap.putIfAbsent(c, new Node());
            currNode = currMap.get(c);
            currMap = currNode.children;
        }
        currNode.isCompleteWord = true;
    }

    public boolean search(String word) {
        Map<Character, Node> currMap = rootMap;
        Node currNode = new Node();
        for (Character c : word.toCharArray()) {
            currNode = currMap.get(c);
            if (currNode == null) {
                return false;
            }
            currMap = currNode.children;
        }

        return currNode.isCompleteWord;
    }

    public boolean startsWith(String prefix) {
        Map<Character, Node> currMap = rootMap;
        for (Character c : prefix.toCharArray()) {
            Node node = currMap.get(c);
            if (node == null) {
                return false;
            }
            currMap = node.children;
        }
        return currMap != null;
    }

}
