package com.njh18.leetcodevault.questions.slidingwindow;


// https://leetcode.com/problems/maximum-average-subarray-i

public class MaxAverageSubArray {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return (double) nums[0] / k;
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        int windowSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum / k;
    }
}
