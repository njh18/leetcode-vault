package com.njh18.leetcodevault.questions.math;


// https://workat.tech/problem-solving/practice/excel-column

public class GetColumnNumber {

    public static void main(String[] args) {
        System.out.println("value is: " + getColumnNumber("Z"));
        System.out.println("value is: " + getColumnNumber("ABCA"));
        System.out.println("value is: " + getColumnNumber("ABC"));
        System.out.println("value is: " + getColumnNumber("AAB"));
    }

    public static int getColumnNumber(String excelColumnNumber) {
        int numOfAlphabets = excelColumnNumber.length();
        int colNum = 0;
        for (int i = 0; i < numOfAlphabets; i++) {
            colNum += (int) Math.pow(26, i);
        }
        for (int i = excelColumnNumber.length() - 1; i >= 0; i--) {
            char c = excelColumnNumber.charAt(i);
            int diff = c - 'A';
            colNum += Math.multiplyExact(diff, (int) Math.pow(26, excelColumnNumber.length() - 1 - i));
        }
        return colNum;
    }
}
