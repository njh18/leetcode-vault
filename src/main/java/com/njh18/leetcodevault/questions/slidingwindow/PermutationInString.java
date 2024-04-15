package com.njh18.leetcodevault.questions.slidingwindow;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
        System.out.println(checkInclusion("ab","eidboaoo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        if (s1.length() == 1) {
            char c = s1.charAt(0);
            for (int i = 0; i < s2.length(); i++) {
                if (s2.charAt(i) == c) {
                    return true;
                }
            }
            return false;
        }

        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        // save freq for A first
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
        }

        // sliding window (window size should at least be length of s1, then check the window
        int left = 0;
        int right = 1;
        freqS2[s2.charAt(left) - 'a']++;
        while (right < s2.length()) {
            freqS2[s2.charAt(right) - 'a']++;
            int lenOfWindow = right - left + 1;

            if (lenOfWindow < s1.length()) {
                right++;
                continue;
            }
            if (isPermutation(freqS1,freqS2)) {
                return true;
            } else {
                freqS2[s2.charAt(left) - 'a']--;
                left++;
                right++;
            }
        }
        return false;
    }

    private static boolean isPermutation(int[] freqS1, int[] freqS2) {
        for (int i = 0; i < 26; i++) {
            if (freqS1[i] != freqS2[i]) {
                return false;
            }
        }
        return true;
    }
}
