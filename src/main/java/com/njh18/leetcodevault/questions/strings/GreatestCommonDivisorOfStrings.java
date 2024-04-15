package com.njh18.leetcodevault.questions.strings;


// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75


import com.njh18.leetcodevault.helper.AlgoHelper;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "AB"));
    }

    public static String gcdOfStrings(String str1, String str2) {

        // check README
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int lengthOfSubString;
        if (str1.length() > str2.length()) {
            lengthOfSubString = AlgoHelper.gcdByEuclidsAlgorithm(str1.length(), str2.length());
        } else {
            lengthOfSubString = AlgoHelper.gcdByEuclidsAlgorithm(str2.length(), str1.length());
        }
        return str1.substring(0, lengthOfSubString);
    }
}
