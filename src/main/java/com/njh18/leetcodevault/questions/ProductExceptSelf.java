package com.njh18.leetcodevault.questions;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        System.out.println("Normal Solution");
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
        System.out.println("Simplified Solution");
        System.out.println(Arrays.toString(productExceptSelf_LessMemory(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf_LessMemory(new int[]{-1,1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftDp = new int[nums.length];
        int[] rightDp = new int[nums.length];

        leftDp[0] = nums[0];
        rightDp[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            leftDp[i] = leftDp[i-1] * nums[i];
        }
        for (int i = nums.length-2; i > 0; i--) {
            rightDp[i] = rightDp[i+1] * nums[i];
        }
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans[i] = rightDp[i+1];
            } else if (i == nums.length - 1) {
                ans[i] = leftDp[nums.length-2];
            } else {
                ans[i] = leftDp[i-1] * rightDp[i+1];
            }
        }
        return ans;
    }

    public static int[] productExceptSelf_LessMemory(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

}
