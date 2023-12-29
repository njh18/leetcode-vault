package com.njh18.leetcodevault.questions;

import java.util.Stack;

class ApplyFloodFill {
    int[][] applyFloodFill(int[][] image, int x, int y, int c) {
        int rows = image.length;
        int cols = image[0].length;
        Stack<int[]> stackCall = new Stack<>();
        stackCall.add(new int[]{x, y});
        int val = image[x][y];
        while (!stackCall.isEmpty()) {
            int[] coord = stackCall.pop();
            int xCoord = coord[0];
            int yCoord = coord[1];
            image[xCoord][yCoord] = c;
            if (yCoord > 0 && image[xCoord][yCoord - 1] == val) {
                stackCall.add(new int[]{xCoord, yCoord - 1});
            }
            if (yCoord < cols - 1 && image[xCoord][yCoord + 1] == val) {
                stackCall.add(new int[]{xCoord, yCoord + 1});
            }
            if (xCoord > 0 && image[xCoord - 1][yCoord] == val) {
                stackCall.add(new int[]{xCoord - 1, yCoord});
            }
            if (xCoord < rows - 1 && image[xCoord + 1][yCoord] == val) {
                stackCall.add(new int[]{xCoord + 1, yCoord});
            }
        }
        return image;
    }
}