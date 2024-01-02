package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.njh18.leetcodevault.helper.TreeNodeHelper.heightOfSubTree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
            if (Math.abs(heightOfSubTree(currNode.left) - heightOfSubTree(currNode.right)) > 1) {
                return false;
            }
        }
        return true;
    }
}
