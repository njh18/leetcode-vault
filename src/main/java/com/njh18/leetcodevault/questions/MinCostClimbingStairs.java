package com.njh18.leetcodevault.questions;


import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs_iterateBackwards(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs_iterateForward(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public static int minCostClimbingStairs_iterateBackwards(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i+1],cost[i+2]);
        }
        return Math.min(cost[0],cost[1]);
    }

    public static int minCostClimbingStairs_iterateForward(int[] cost) {
        // sum[i] shows current max cost to reach this step
        int[] sum = new int[cost.length+1];
        for (int i = 2; i < sum.length; i++) {
            int moving1Step = sum[i-1] + cost[i-1];
            int moving2Steps = sum[i-2] + cost[i-2];
            sum[i] = Math.min(moving1Step, moving2Steps);
        }
        return sum[sum.length-1];
    }
}
