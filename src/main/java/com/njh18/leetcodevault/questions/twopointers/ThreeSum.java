package com.njh18.leetcodevault.questions.twopointers;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-2,0,1,1,2});
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // nlogn
        Arrays.sort(nums);
        // n
        Integer prev = null;
        for (int i = 0; i < nums.length; i++) {
            if (prev != null && prev == nums[i]) {
                // already calculated, no need to go through process again
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            Integer leftPrev = null;
            Integer rightPrev = null;
            while (left < right) {
                if (leftPrev != null && leftPrev == nums[left]) {
                    left++;
                    continue;
                }
                if (rightPrev != null && rightPrev == nums[right]) {
                    right--;
                    continue;
                }

                int currSum = nums[left] + nums[right];
                if (currSum == target) {
                    ans.add(List.of(nums[i],nums[left],nums[right]));
                    leftPrev = nums[left];
                    rightPrev = nums[right];
                    left++;
                    right--;
                    continue;
                }
                if (currSum > target) {
                    rightPrev = nums[right];
                    right--;
                } else {
                    leftPrev = nums[left];
                    left++;
                }
            }
            prev = nums[i];
        }
        return ans;
    }
}
