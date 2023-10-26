package com.njh18.leetcodevault.questions;

//https://leetcode.com/problems/is-subsequence
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        // if t shorter than s, s cannot be a substring of t
        if (t.length() < s.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int sPointer = 0;
        char currCharFromS = s.charAt(sPointer);
        for (int i = 0; i < t.length(); i++) {
            if (currCharFromS == t.charAt(i)) {
                sPointer += 1;
                if (sPointer == s.length()) {
                    return true;
                } else {
                    currCharFromS = s.charAt(sPointer);
                }
            }
        }
        return false;
    }
}
