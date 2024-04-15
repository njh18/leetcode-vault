package com.njh18.leetcodevault.questions.bitmanipulation;

public class MissingNumber {

    public static void main(String[] args) {
        missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        missingNumber_betterSpaceCompexity(new int[]{9,6,4,2,3,5,7,8,1});
    }
    public static int missingNumber(int[] nums) {
        int[] exitingValues = new int[nums.length];
        for (int num : nums) {
            if (num != nums.length) {
                exitingValues[num] = 1;
            }
        }

        for (int i = 0; i < exitingValues.length; i++) {
            if (exitingValues[i] == 0) {
                return i;
            }
        }
        return nums.length;
    }

    public static int missingNumber_betterSpaceCompexity(int[] nums) {
        int supposedSum = (nums.length + 1) * (nums.length) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum+=num;
        }
        return supposedSum - actualSum;
    }
}
