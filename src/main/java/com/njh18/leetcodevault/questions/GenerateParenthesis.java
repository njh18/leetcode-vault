package com.njh18.leetcodevault.questions;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateParenthesis {

    public static void main(String[] args) {
//        System.out.println(generateParenthesis(2));
//        System.out.println(generateParenthesis(3));
//        System.out.println(generateParenthesis(4));
    }

    List<String> res;
    int count;
    Stack<String> tempStack;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        count = n;
        tempStack = new Stack<>();
        backTrack(0,0);
        return res;
    }

    private void backTrack(int leftCount, int rightCount) {
        if (leftCount == rightCount && rightCount == count) {
            res.add(tempStack.stream().collect(Collectors.joining()));
            return;
        }

        if (leftCount < count) {
            tempStack.add("(");
            backTrack(leftCount+1, rightCount);
            tempStack.pop();
        }

        if (rightCount < leftCount) {
            tempStack.add(")");
            backTrack(leftCount,rightCount+1);
            tempStack.pop();
        }
    }
}
