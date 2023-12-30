package com.njh18.leetcodevault.helper;

public class AlgoHelper {

    public static int gcdByEuclidsAlgorithm(int bigNum, int smallNum) {
        if (smallNum == 0) {
            return bigNum;
        }
        return gcdByEuclidsAlgorithm(smallNum, bigNum % smallNum);
    }
}
