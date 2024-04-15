package com.njh18.leetcodevault.questions.trees;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if (currNode.left != null || currNode.right != null) {
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                TreeNode temp = currNode.right;
                currNode.right = currNode.left;
                currNode.left = temp;
            }
        }
        return root;
    }
}
