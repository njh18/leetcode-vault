package com.njh18.leetcodevault.questions.strings;


import java.util.*;

public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive_bruteForce(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive_bruteForce(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive_bruteForce(new int[]{-2,0,-6,-9,-8,6,-7,-5,-7,3,3,-7,-5,-5,3,3,-4}));
    }

    public static int longestConsecutive_bruteForce(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int counter = 1;
        int maxSeq = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] == nums[i]) {
                continue;
            }
            if (nums[i+1] - nums[i] == 1) {
                counter+=1;
                maxSeq=Math.max(maxSeq, counter);
            } else {
                counter=1;
            }
        }
        return maxSeq;
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSeq = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int uniqNum : set) {
            if (!set.contains(uniqNum-1)) {
                int lenOfCurrSeq = 0;
                while (set.contains(uniqNum + lenOfCurrSeq)) {
                    lenOfCurrSeq++;
                }
                maxSeq = Math.max(maxSeq,lenOfCurrSeq);
            }
        }

        return maxSeq;
    }


}
