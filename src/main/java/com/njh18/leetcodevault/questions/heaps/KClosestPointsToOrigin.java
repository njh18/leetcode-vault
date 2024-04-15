package com.njh18.leetcodevault.questions.heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {


    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> comparator = Comparator.comparingDouble(
                a -> Math.pow(a[0], 2) + Math.pow(a[1], 2));
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        Collections.addAll(queue, points);
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] curr = queue.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
        }
        return ans;
    }
}
