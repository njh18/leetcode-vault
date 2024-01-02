package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class DiameterOfBinaryTree {

    int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int diameter = Integer.MIN_VALUE;
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
            diameter = Math.max(diameter,
                    heightOfSubTree(currNode.left) + heightOfSubTree(currNode.right));
        }
        return diameter;
    }

    public int diameterOfBinaryTree_Improved(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameter = heightOfSubTree(root.left) + heightOfSubTree(root.right);
        int leftDiameter = diameterOfBinaryTree_Improved(root.left);
        int rightDiameter = diameterOfBinaryTree_Improved(root.right);
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    public int diameterOfBinaryTree_WithSolutionAsClassVariable(TreeNode root) {
        maxDiameter = 0;
        heightOfSubTree_WithUpdateToMaxDiameter(root);
        return maxDiameter;
    }

    private int heightOfSubTree_WithUpdateToMaxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfSubTree_WithUpdateToMaxDiameter(root.left);
        int rightHeight = heightOfSubTree_WithUpdateToMaxDiameter(root.right);

        // this is special for the solution, if without this, its just a normal recursive to get height of root
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int heightOfSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfSubTree(root.left), heightOfSubTree(root.right));
    }
}
