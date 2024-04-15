package com.njh18.leetcodevault.questions.backtracking;

import java.util.*;

public class CombinationSum2 {

    List<List<Integer>> res;

    List<Integer> temp;
    int mainTarget;
    int currSum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        mainTarget = target;
        currSum = 0;
        backTrack(0, candidates);
        return res;
    }

    private void backTrack(int i, int[] candidates) {
        if (currSum == mainTarget) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // reach end of list already no need to continue
        if (i + 1 > candidates.length) {
            return;
        }

        // if already exceed means no need to continue the remaining as it is sorted
        if (currSum + candidates[i] > mainTarget) {
            return;
        }

        // include nums[i]
        temp.add(candidates[i]);
        currSum = currSum + candidates[i];
        backTrack(i + 1, candidates);

        temp.remove(temp.size() - 1);
        currSum = currSum - candidates[i];


        // don't include nums[i];
        // similar to subset2, if nums[i] = 2 and nums[i+1] = 2, this should not be included also
        while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        backTrack(i + 1, candidates);
    }
}
