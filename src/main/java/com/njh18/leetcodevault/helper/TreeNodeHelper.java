package com.njh18.leetcodevault.helper;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeHelper {

    public static int heightOfSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfSubTree(root.left), heightOfSubTree(root.right));
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderTraversal(root.left, result);
            result.add(root.val);
            inOrderTraversal(root.right, result);
        }
    }
}
