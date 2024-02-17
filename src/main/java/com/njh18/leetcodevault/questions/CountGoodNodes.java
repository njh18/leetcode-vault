package com.njh18.leetcodevault.questions;

import com.njh18.leetcodevault.model.TreeNode;

public class CountGoodNodes {

    public int ans;

    public int goodNodes(TreeNode root) {
        ans = 0;
        checkIsMax(root, Integer.MIN_VALUE);
        return ans;
    }

    public void checkIsMax(TreeNode currNode, int currMax) {
        if (currNode.val >= currMax) {
            ans++;
            currMax = currNode.val;
        }
        if (currNode.left != null) {
            checkIsMax(currNode.left, currMax);
        }
        if (currNode.right != null) {
            checkIsMax(currNode.right, currMax);
        }
    }
}
