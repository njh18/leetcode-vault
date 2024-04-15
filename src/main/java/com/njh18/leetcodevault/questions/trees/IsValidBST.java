package com.njh18.leetcodevault.questions.trees;

import com.njh18.leetcodevault.helper.TreeNodeHelper;
import com.njh18.leetcodevault.model.TreeNode;

import java.util.List;

public class IsValidBST {

    public boolean isValidBST_bruteForce(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> orderList = TreeNodeHelper.inOrderTraversal(root);

        for (int i = 0; i < orderList.size() - 1; i++) {
             if (orderList.get(i) >= orderList.get(i+1)) {
                 return false;
             }
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        return checkIsValid(root, left, right);
    }

    private boolean checkIsValid(TreeNode curr, long left, long right) {
        if (curr == null) {
            return true;
        }
        if (curr.val <= left || curr.val >= right) {
            return false;
        }
        // left child must be between left bound and curr node
        // right child must be between curr node and right bound
        return checkIsValid(curr.left, left, curr.val) && checkIsValid(curr.right, curr.val, right);
    }


}
