package com.njh18.leetcodevault.questions.stack;

import java.util.*;

public class DailyTemperature {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(dailyTemperatures_bruteForce(new int[]{73,74,75,71,69,72,76,73})));
//        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    public static int[] dailyTemperatures_bruteForce(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; i++) {
            boolean found = false;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans[i] = 0;
            }
        }
        return ans;
    }

    class Pair {
        int temp;
        int index;

        public Pair(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && currTemp > stack.peek().temp) {
                Pair poppedtemp = stack.pop();
                ans[poppedtemp.index] = i - poppedtemp.index;
            }
            stack.add(new Pair(currTemp, i));
        }
        return ans;
    }
}
