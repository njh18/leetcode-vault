package com.njh18.leetcodevault.questions;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','B','B','A','B'},2));
    }
    public static int leastInterval(char[] tasks, int n) {
        int[] freqList = new int[26];

        for (char c: tasks) {
            freqList[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int freq: freqList) {
            if (freq != 0) {
                maxHeap.add(freq);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>(); // 0 - count, 1 - idleTime;

        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int newFreq = maxHeap.poll() - 1;
                if (newFreq != 0) {
                    int[] pair = new int[2];
                    pair[0] = newFreq;
                    pair[1] = time + n;
                    queue.add(pair);
                }
            }

            if (!queue.isEmpty()) {
                int[] peek = queue.peek();
                if (peek[1] == time) {
                    maxHeap.add(peek[0]);
                    queue.poll();
                }
            }
        }
        return time;
    }
}
