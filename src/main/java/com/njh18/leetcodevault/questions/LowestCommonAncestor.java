package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.Stack;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor_moreEfficientSolution(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor_bruteForceWithStack(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> ancestorOfP = new Stack<>();
        Stack<TreeNode> ancestorOfQ = new Stack<>();

        TreeNode curr = root;
        while (curr.val != p.val) {
            ancestorOfP.add(curr);
            if (curr.val > p.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        ancestorOfP.add(curr);

        curr = root;
        while (curr.val != q.val) {
            ancestorOfQ.add(curr);
            if (curr.val > q.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        ancestorOfQ.add(curr);


        while (!ancestorOfP.isEmpty() && !ancestorOfQ.isEmpty()) {
            TreeNode currQ = ancestorOfQ.peek();
            TreeNode currP = ancestorOfP.peek();

            if (currQ.val == currP.val) {
                return currQ;
            }
            if (ancestorOfQ.size() < ancestorOfP.size()) {
                ancestorOfP.pop();
            } else {
                ancestorOfQ.pop();
            }
        }
        return root;
    }
}
