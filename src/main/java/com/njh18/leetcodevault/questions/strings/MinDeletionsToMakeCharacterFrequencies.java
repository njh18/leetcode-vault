package com.njh18.leetcodevault.questions.strings;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class MinDeletionsToMakeCharacterFrequencies {


    public static void main(String[] args) {
    }

    public static int minDeletions(String s) {
        Map<String, Integer> strFreqMap = new HashMap<>();
        int deletions = 0;

        // map characters to their frequencies
        String[] stringArray = s.split("");
        for (String string: stringArray) {
            strFreqMap.put(string, strFreqMap.getOrDefault(string, 0) + 1);
        }

        // get all freq into the set, if freq already there, minus freq until 0 or until set does not contain freq
        HashSet<Integer> setOfFreq = new HashSet<>();
        for (int freq : strFreqMap.values()) {
            while (freq > 0 && setOfFreq.contains(freq)) {
                freq--;
                deletions++;
            }
            setOfFreq.add(freq);
        }

        return deletions;
    }
}
