package com.njh18.leetcodevault.questions;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().findFirst().get();
    }

    public int singleNumber_bitManipulation(int[] nums) {
        int result = 0;
        for (int num :
                nums) {
            result ^= num;
        }
        return result;
    }
}
