package com.njh18.leetcodevault.questions.binarysearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }


    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            int leftNum = nums[left];
            int midNum = nums[mid];
            int rightNum = nums[right];

            if (midNum == target) {
                return mid;
            }
            // left sorted
            if (leftNum <= midNum) {
                if (target > midNum || target < leftNum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < midNum || target > rightNum) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
