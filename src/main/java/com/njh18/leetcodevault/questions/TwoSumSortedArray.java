package com.njh18.leetcodevault.questions;

import java.util.Arrays;

public class TwoSumSortedArray {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-3,3,4,90}, 0)));

    }
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1,2};
        }
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currSum = numbers[left] + numbers[right];
            // possibilities:
            // currSum is the Target -> return straight away
            if (currSum == target) {
                return new int[]{left+1, right+1};
            }

            // currSum bigger than target -> so must move right pointer by 1
            if (currSum > target) {
                right--;
            } else {
                // currSum smaller than target -> must move left pointer by 1
                left ++;
            }
        }
        return new int[]{left+1,right+1};
    }
}
