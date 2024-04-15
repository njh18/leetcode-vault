package com.njh18.leetcodevault.questions.heaps;

import java.util.PriorityQueue;

public class KthLargest {

    final PriorityQueue<Integer> heap = new PriorityQueue<>();
    final int k;

    public static void main(String[] args) {
        KthLargest n = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(n.add(3));
    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i :
                nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
