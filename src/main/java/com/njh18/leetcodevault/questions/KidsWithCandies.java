package com.njh18.leetcodevault.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies.length == 0) {
            return Collections.emptyList();
        }
        int maxVal = Arrays.stream(candies).max().getAsInt();
        List<Boolean> booleanList = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            int currentKid = candies[i];
            booleanList.add(i, currentKid + extraCandies >= maxVal);
        }
        return booleanList;
    }
}
