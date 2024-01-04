package com.njh18.leetcodevault.questions;

public class ClimbStairs {

//    basically like fibonacci, but cannot use recursive cause need memo the values, so do iterative

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int minus_one_step = 1;
        int minus_two_step = 2;
        int numOfWays = 0;

        for (int i = 2; i < n; i++) {
            numOfWays = minus_one_step + minus_two_step;
            minus_two_step = minus_one_step;
            minus_one_step = numOfWays;
        }
        return numOfWays;
    }
}
