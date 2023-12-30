package com.njh18.leetcodevault.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] twoDArray = {
                {3, 7},
                {1, 5},
                {4, 9},
                {2, 3}
        };
        System.out.println(Arrays.deepToString(merge(twoDArray)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        Stack<int[]> intervalStack = new Stack<>();

        for (int[] currInterval : intervals) {
            if (intervalStack.isEmpty()) {
                intervalStack.push(currInterval);
            } else {
                int[] topInterval = intervalStack.peek();
                if (topInterval[1] > currInterval[0]) {
                    topInterval[1] = Math.max(topInterval[1], currInterval[1]);
                } else {
                    intervalStack.push(currInterval);
                }
            }
        }
        return intervalStack.toArray(int[][]::new);
    }
}
