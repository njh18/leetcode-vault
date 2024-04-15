package com.njh18.leetcodevault.questions.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    public class Node {
        Node[] children;
        boolean isCompleteWord;

        public Node() {
            this.children = new Node[26];
            this.isCompleteWord = false;
        }
    }

    public Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        if (word.isEmpty()) {
            return;
        }
        Node curr = root;
        for (char c : word.toCharArray()) {
            Node[] children = curr.children;
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new Node();
            }
            curr = children[c - 'a'];
        }
        curr.isCompleteWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper(String word, Node curr, int index) {
        for (int i = index; i < word.length() ; i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (Node child : curr.children) {
                    if (child != null && searchHelper(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            }

            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isCompleteWord;
    }


}
