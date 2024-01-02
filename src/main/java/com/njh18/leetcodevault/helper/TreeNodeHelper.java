package com.njh18.leetcodevault.helper;

import com.njh18.leetcodevault.model.TreeNode;

public class TreeNodeHelper {

    public static int heightOfSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfSubTree(root.left), heightOfSubTree(root.right));
    }
}
