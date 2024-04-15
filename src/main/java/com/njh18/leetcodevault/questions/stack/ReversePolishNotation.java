package com.njh18.leetcodevault.questions.stack;

import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

    public static List<String> allOperators = List.of("+","-","*","/");



    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"3","4","*","5","6","*","+"}));
    }
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stackOfNums = new Stack<>();
        for (String val: tokens) {
            if (isOperator(val)) {
                // pop last 2, then combine with operator, then add back to stack
                Integer num2 = stackOfNums.pop();
                Integer num1 = stackOfNums.pop();
                int combinedVal = calcVal(num1, num2, val);
                stackOfNums.push(combinedVal);
                continue;
            }
            stackOfNums.push(Integer.parseInt(val));
        }
        return stackOfNums.peek();
    }

    private static int calcVal(Integer num1, Integer num2, String val) {
        switch (val) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            case "/" -> {
                return num1 / num2;
            }
        }
        return 0;
    }

    private static boolean isOperator(String val) {
        return allOperators.contains(val);
    }

}
