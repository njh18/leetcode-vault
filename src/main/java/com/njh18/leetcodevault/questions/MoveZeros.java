package com.njh18.leetcodevault.questions;


import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/move-zeroes/description
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        Queue<Integer> zeroIndexes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndexes.add(i);
                if (nums.length - i == zeroIndexes.size()) {
                    return;
                }
                continue;
            }

            if (!zeroIndexes.isEmpty()) {
                nums[zeroIndexes.remove()] = nums[i];
                nums[i] = 0;
                zeroIndexes.add(i);
            }
        }
    }
}
