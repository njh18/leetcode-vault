package com.njh18.leetcodevault.questions.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://leetcode.com/problems/search-suggestions-system/description/
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // sort the products in order first -> O(nlogn)
        Arrays.sort(products);

        List<List<String>> res = new ArrayList<>();
        // length of search = k
        // O(k * n) complexity
        for (int i = 1; i<= searchWord.length(); i++) {
            String curr = searchWord.substring(0, i);
            List<String> currRes = new ArrayList<>();
            int count = 0;
            for (String product: products) {
                if (count == 3) {
                    break;
                }
                if (product.startsWith(curr)) {
                    currRes.add(product);
                    count++;
                }
            }
            res.add(currRes);
        }
        // total complexity O(nlogn + kn)
        return res;
    }



}