package com.njh18.leetcodevault.questions;


// https://workat.tech/problem-solving/practice/flood-fill-image

import java.util.Stack;

public class FloodFillImage {

    public int[][] applyFloodFill(int[][] image, int x, int y, int c) {
        int rows = image.length;
        int cols = image[0].length;

        // add your logic here
        Stack<int[]> stackCall = new Stack<>();

        stackCall.add(new int[]{x, y});
        int val = image[x][y];

        while (!stackCall.isEmpty()) {

            int[] coord = stackCall.pop();
            // update as flood call
            int xCoord = coord[0];
            int yCoord = coord[1];

            image[xCoord][yCoord] = c;

            // add left cell
            if (yCoord > 0 && image[xCoord][yCoord - 1] == val) {
                stackCall.add(new int[]{xCoord, yCoord - 1});
            }
            // add right cell
            if (yCoord < cols - 1 && image[xCoord][yCoord + 1] == val) {
                stackCall.add(new int[]{xCoord, yCoord + 1});
            }

            // add top cell
            if (xCoord > 0 && image[xCoord - 1][yCoord] == val) {
                stackCall.add(new int[]{xCoord - 1, yCoord});
            }
            // add btm cell
            if (xCoord < rows - 1 && image[xCoord + 1][yCoord] == val) {
                stackCall.add(new int[]{xCoord + 1, yCoord});
            }
        }
        return image;
    }
}

