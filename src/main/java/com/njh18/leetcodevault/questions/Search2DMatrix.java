package com.njh18.leetcodevault.questions;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] array2D = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(array2D, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 1;
        int high = row * col;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            // [1][0]
            // (5-1) / 4 -> 1
            // 5 % 4 -> 1 - 1 = 0

            // [1][3]
            // (8-1) / 4 -> 1;
            // (8-1) % 4 -> 3;

            // 10
            // [2][1]
            // (10-1) / 4 -> 2.5 -> 2
            // (10-1) % 4 -> 1;
            int currRow = (mid-1) / col;
            int currCol = (mid-1) % col;

            if (matrix[currRow][currCol] < target) {
                low = mid + 1;
            } else if (matrix[currRow][currCol] > target) {
                high = mid - 1;
            } else if (matrix[currRow][currCol] == target) {
                return true;
            }
        }
        return false;
    }

}
