package com.njh18.leetcodevault.questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsWithDup {

    public List<List<Integer>> res;
    public List<Integer> currSubset;
    public List<List<Integer>> subsetsWithDup_bruteForce(int[] nums) {
        res = new ArrayList<>();
        currSubset = new ArrayList<>();
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i >= nums.length) {
            // need to copy into new array before adding else all values will be added
            List<Integer> list = new ArrayList<>(currSubset);
            Collections.sort(list);
            if (!res.contains(list)) {
                res.add(list);
            }
            return;
        }
        // decision to include nums[i]
        currSubset.add(nums[i]);
        dfs(i + 1, nums);
        // dont include nums[i]
        currSubset.remove(currSubset.size() - 1);
        dfs(i + 1, nums);
    }


    public List<List<Integer>> subsetsWithDup_improved(int[] nums) {
        res = new ArrayList<>();
        currSubset = new ArrayList<>();
        // need to sort to tell which elements have been duplicated
        Arrays.sort(nums);
        dfs_improved(0, nums);
        return res;
    }

    private void dfs_improved(int i, int[] nums) {
        if (i == nums.length) {
            // need to copy into new array before adding else all values will be added
            res.add(new ArrayList<>(currSubset));
            return;
        }

        // decision to include nums[i]
        currSubset.add(nums[i]);
        dfs_improved(i + 1, nums);
        currSubset.remove(currSubset.size() - 1);

        // don't include nums[i]
        // e.g. if nums[1] == 2 and nums[2] == 2, permanently exclude all 2s from bottom decision tree
        // this is because the same 2 will be handled in the above decision tree
        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        dfs_improved(i + 1, nums);
    }

}
