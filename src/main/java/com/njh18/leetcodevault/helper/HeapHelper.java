package com.njh18.leetcodevault.helper;

public class HeapHelper {

    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    public static int parent(int i) {
        // already at root node, it's not parent
        if (i == 0) return -1;
        return (i - 2) / 2;
    }

}
