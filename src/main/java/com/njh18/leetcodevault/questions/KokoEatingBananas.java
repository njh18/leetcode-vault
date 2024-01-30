package com.njh18.leetcodevault.questions;

import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
//        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // minBananaPerHr and maxBananaPerHr
        int minBananaPerHr = 1;
        int maxBananaPerHr = Arrays.stream(piles).max().getAsInt();

        int ans = maxBananaPerHr;
        while (minBananaPerHr <= maxBananaPerHr) {
            int mid = minBananaPerHr + ((maxBananaPerHr - minBananaPerHr) / 2);
            long timeTakenToFinishBananas = 0;

            for (int i = 0; i < piles.length; i++) {
                int pile = piles[i];
                if (pile <= mid) {
                    timeTakenToFinishBananas++;
                } else  {
                    double result = (double) pile / mid;
                    int timeTakenForPile = (int) Math.ceil(result);
                    timeTakenToFinishBananas += timeTakenForPile;
                }
            }

            if (timeTakenToFinishBananas > h) {
                minBananaPerHr = mid + 1;
            } else {
                maxBananaPerHr = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
        return ans;
    }
}
