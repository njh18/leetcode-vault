package com.njh18.leetcodevault.questions;


import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String currentWord : strs) {
            char[] charArray = currentWord.toCharArray();
            Arrays.sort(charArray);
            List<String> smallList = groupedAnagrams.getOrDefault(String.valueOf(charArray), new ArrayList<>());
            smallList.add(currentWord);
            groupedAnagrams.put(String.valueOf(charArray), smallList);
        }
        return groupedAnagrams.values().stream().toList();
    }

}
