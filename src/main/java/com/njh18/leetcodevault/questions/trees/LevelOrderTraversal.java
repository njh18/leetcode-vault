package com.njh18.leetcodevault.questions.trees;

import com.njh18.leetcodevault.model.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    public static class NodeWithLevel {
        TreeNode node;
        int level;

        NodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder_LessSpace(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.add(root);
        while (!queue.isEmpty()) {
            // we get the len of queue for that particular level
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<NodeWithLevel> queue = new ArrayDeque<>();
        queue.add(new NodeWithLevel(root, 0));
        while (!queue.isEmpty()) {
            NodeWithLevel currNodeWithLevel = queue.poll();
            TreeNode currNode = currNodeWithLevel.node;
            int level = currNodeWithLevel.level;

            if (currNode.left != null) {
                queue.add(new NodeWithLevel(currNode.left, level + 1));
            }
            if (currNode.right != null) {
                queue.add(new NodeWithLevel(currNode.right, level + 1));
            }

            if (ans.size() < level + 1) {
                List<Integer> curr = new ArrayList<>();
                curr.add(currNode.val);
                ans.add(curr);
            } else {
                List<Integer> curr = ans.get(level);
                curr.add(currNode.val);
            }
        }
        return ans;
    }
}
