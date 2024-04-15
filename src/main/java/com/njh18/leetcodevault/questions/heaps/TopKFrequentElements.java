package com.njh18.leetcodevault.questions.heaps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequentElements {

    public int[] topKFrequent_BruteForce(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
        }

        // priority queue based on
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        maxHeap.addAll(frequencyMap.entrySet());

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(maxHeap.poll().getKey());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] topKFrequent_useMinHeapWithKElements(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());


        for (Map.Entry<Integer, Integer> keyValue : frequencyMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(keyValue);
            } else {
                if (keyValue.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(keyValue);
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k-1; i >= 0; i--) {
            ans[i] = minHeap.poll().getKey();
        }
        return ans;
    }

    public int[] topKFrequent_usingArrayList(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
        }

        // using buckets
        List<List<Integer>> freqBuckets = IntStream.range(0, nums.length + 1)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> keyValue : frequencyMap.entrySet()) {
            freqBuckets.get(keyValue.getValue()).add(keyValue.getKey());
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = freqBuckets.size() - 1 ; i >= 0 ; i--) {
            List<Integer> currBucket = freqBuckets.get(i);
            if (!currBucket.isEmpty()) {
                ans.addAll(currBucket);
            }
            if (ans.size() == k) {
                return ans.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
