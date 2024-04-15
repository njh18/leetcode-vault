package com.njh18.leetcodevault.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> lists = permutations.permute(new int[]{1, 2, 3});
        System.out.println(lists);
    }

    List<List<Integer>> res;
    List<Integer> curr;
    int length;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        curr = new ArrayList<>();
        length = nums.length;
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (curr.size() == length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int currNum : nums) {
            if (!curr.contains(currNum)) {
                curr.add(currNum);
                dfs(nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
