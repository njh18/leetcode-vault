package com.njh18.leetcodevault.questions.slidingwindow;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
//        System.out.println(characterReplacement("ABAB",2));
//        System.out.println(characterReplacement("AABABBA",1));
        System.out.println(characterReplacement("ABBB",2));

//        System.out.println(characterReplacement("ABAA",0));
    }
    public static int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        Map<Character,Integer> freqCount = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freqCount.put(s.charAt(right), freqCount.getOrDefault(s.charAt(right),0) + 1);
            int maxFreq = getMaxValueInHashMap(freqCount);
            while (right - left + 1 - maxFreq > k ) {
                freqCount.put(s.charAt(left), freqCount.get(s.charAt(left)) -1);
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }

    private static int getMaxValueInHashMap(Map<Character, Integer> freqCount) {
        return freqCount.values().stream().max(Comparator.comparingInt(Integer::intValue)).get();

    }

    public static int characterReplacement_maintainMaxFreq(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        Map<Character,Integer> freqCount = new HashMap<>();
        int ans = 0;
        int left = 0;
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            int currFreq = freqCount.getOrDefault(s.charAt(right), 0) + 1;
            freqCount.put(s.charAt(right), currFreq);
            maxFreq = Math.max(maxFreq,currFreq);
            while (right - left + 1 - maxFreq > k ) {
                freqCount.put(s.charAt(left), freqCount.get(s.charAt(left)) -1);
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
