package com.njh18.leetcodevault.questions.trees;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {


    // similar to levelOrderTraversal but we just take the last value of each level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;

        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            int last = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                last = curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (last != Integer.MIN_VALUE) {
                res.add(last);
            }
        }
        return res;
    }

}
