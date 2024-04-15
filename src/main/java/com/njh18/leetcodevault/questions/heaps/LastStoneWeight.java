package com.njh18.leetcodevault.questions.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int biggest = queue.poll();
            int secondBiggest = queue.poll();
            if (biggest != secondBiggest) {
                queue.offer(biggest-secondBiggest);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
