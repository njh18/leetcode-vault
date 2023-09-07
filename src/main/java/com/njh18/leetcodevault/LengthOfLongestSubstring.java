package com.njh18.leetcodevault;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        String test = "";
        // result
        int maxLength = -1;

        // Return zero if string is empty
        if (s.isEmpty()) {
            return 0;
        }

        // Return 1 if string length is one
        else if (s.length() == 1) {
            return 1;
        }

        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);

            // if string already contains the charcter
            // then get substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test = test + c;
            maxLength = Math.max(test.length(), maxLength);
        }
        return maxLength;
    }
}
