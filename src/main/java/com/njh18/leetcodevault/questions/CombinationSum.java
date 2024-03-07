package com.njh18.leetcodevault.questions;

import java.util.*;

public class CombinationSum {

    Set<List<Integer>> res;

    List<Integer> temp;

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new HashSet<>();
        temp = new ArrayList<>();
        backTrack(candidates, target);
        return new ArrayList<>(res);
    }

    private void backTrack(int[] candidates, int target) {
        if (!temp.isEmpty() &&
                temp.stream().mapToInt(Integer::intValue).sum() == target) {
            List<Integer> integers = new ArrayList<>(temp);
            Collections.sort(integers);
            res.add(integers);
            return;
        }
        if (temp.stream().mapToInt(Integer::intValue).sum() > target) {
            // exceed already, no need to continue adding to the list
            return;
        }
        for (int curr : candidates) {
            temp.add(curr);
            backTrack(candidates, target);
            temp.remove(temp.size() - 1);
        }
    }
}
