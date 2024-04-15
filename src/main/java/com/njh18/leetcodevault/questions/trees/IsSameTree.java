package com.njh18.leetcodevault.questions.trees;

import com.njh18.leetcodevault.model.TreeNode;

public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // if reach here means both are not null
        if (p == null || q == null) {
            // here means one of it is null and that means both not the same
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
