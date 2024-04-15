package com.njh18.leetcodevault.questions.arrays;


// https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
public class CanPlaceFlowers {

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = i == 0 || flowerbed[i-1] == 0;
                boolean emptyRightPlot = i == flowerbed.length -1 || flowerbed[i+1] == 0;
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
