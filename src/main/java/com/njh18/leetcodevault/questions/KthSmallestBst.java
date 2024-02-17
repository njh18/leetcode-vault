package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.TreeNode;

public class KthSmallestBst {

    TreeNode ansNode;
    int kthVal;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        kthVal = k;
        count = 0;
        inOrderTraversal(root);
        return ansNode.val;
    }

    private void inOrderTraversal(TreeNode curr) {
        if (count == kthVal) {
            return;
        }
        if (curr != null) {
            inOrderTraversal(curr.left);
            // need this because if recrusive the parent might get added
            if (count != kthVal) {
                ansNode = curr;
                count++;
            }
            inOrderTraversal(curr.right);
        }
    }
}
