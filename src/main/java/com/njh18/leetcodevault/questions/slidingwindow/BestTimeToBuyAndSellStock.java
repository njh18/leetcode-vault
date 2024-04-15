package com.njh18.leetcodevault.questions.slidingwindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {


    public static void main(String[] args) {
        int[] sample = new int[] {3,2,6,5,0,3};
        maxProfit(sample);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int maxProfit = 0;

        int lowestPointSoFar = prices[0];
        int highestPointFromLowestPoint = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curVal = prices[i];
            if (curVal < lowestPointSoFar) {
                lowestPointSoFar = curVal;
                highestPointFromLowestPoint = curVal;
                continue;
            }

            if (curVal > highestPointFromLowestPoint) {
                highestPointFromLowestPoint = curVal;
                maxProfit = Math.max(maxProfit, highestPointFromLowestPoint - lowestPointSoFar);
            }

        }

        return maxProfit;
    }



}
