package com.njh18.leetcodevault.questions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description
public class ReverseVowelsString {

    public String reverseVowels(String s) {
        if (s.length() == 1) {
            return s;
        }

        String[] split = s.split("");
        Stack<String> vowels = new Stack<>();

        for (String string : split) {
            if (isVowel(string)) {
                vowels.push(string);
            }
        }

        for (int i = 0; i < split.length; i++) {
            if (isVowel(split[i])) {
                split[i] = vowels.pop();
            }
        }
        return String.join("", split);
    }

    private boolean isVowel(String string) {
        List<String> vowelList = List.of("a","e","i","o","u");
        return vowelList.stream().anyMatch(vowel -> vowel.equalsIgnoreCase(string));
    }


    public String reverseVowelsDoublePointerSolution(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        String[] result = s.split("");

        while (startIndex < endIndex) {
            String startChar = result[startIndex];
            String endChar = result[endIndex];

            if (!isVowel(startChar)) {
                startIndex++;
            } else if (!isVowel(endChar)) {
                endIndex--;
            } else {
                String tmp = result[startIndex];
                result[startIndex] = result[endIndex];
                result[endIndex] = tmp;
                startIndex++;
                endIndex--;
            }
        }

        return String.join("", result);
    }

}
