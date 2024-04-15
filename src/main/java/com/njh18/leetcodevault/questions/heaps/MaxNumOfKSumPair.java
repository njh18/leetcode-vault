package com.njh18.leetcodevault.questions.heaps;

import java.util.*;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
public class MaxNumOfKSumPair {

    public int maxOperations(int[] nums, int k) {
        int numOfOperations = 0;
        Map<Integer, List<Integer>> valIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];
            if (currentVal > k) {
                continue;
            }
            if (valIndexMap.containsKey(k -currentVal)) {
                numOfOperations++;
                List<Integer> indexList = valIndexMap.get(k - currentVal);
                if (indexList.size() == 1) {
                    valIndexMap.remove(k - currentVal);
                } else {
                    indexList.remove(0);
                    valIndexMap.put(k - currentVal, indexList);
                }
            } else {
                if (valIndexMap.containsKey(currentVal)) {
                    valIndexMap.get(currentVal).add(i);
                } else {
                    valIndexMap.put(currentVal, new ArrayList<>(List.of(i)) );
                }
            }
        }
        return numOfOperations;
    }
}
