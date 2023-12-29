package com.njh18.leetcodevault.questions;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        String lowerCasedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = lowerCasedString.length() - 1;

        while (left < right) {
            if (lowerCasedString.charAt(left) != lowerCasedString.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

}
