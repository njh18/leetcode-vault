package com.njh18.leetcodevault.questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> res;
    public List<Integer> currSubset;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        currSubset = new ArrayList<>();
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i >= nums.length) {
            // need to copy into new array before adding else all values will be added
            res.add(new ArrayList<>(currSubset));
            return;
        }
        // decision to include nums[i]
        currSubset.add(nums[i]);
        dfs(i + 1, nums);
        // dont include nums[i]
        currSubset.remove(currSubset.size() - 1);
        dfs(i + 1, nums);
    }
}
