package com.njh18.leetcodevault.questions;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            int sum = findSquare(n);
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

    private int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10 ;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
}
