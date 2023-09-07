package com.njh18.leetcodevault;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // key: number
        // value: index of number
        Map<Integer,Integer> hashMap = new HashMap<>();

        int[] answer = new int[2];

        // loop through array
        for (int i = 0; i < nums.length; i++) {
            // if map contains the diff between target and current number, answer is found
            if (hashMap.containsKey(target - nums[i])) {
                answer[0] = hashMap.get(target - nums[i]);
                answer[1] = i;
                break;
            } else {
                hashMap.put(nums[i],i);
            }
        }
        return answer;
    }
}
