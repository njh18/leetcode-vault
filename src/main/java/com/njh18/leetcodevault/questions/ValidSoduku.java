package com.njh18.leetcodevault.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSoduku {

    public static void main(String[] args) {

        char[][] sudokuBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(sudokuBoard));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        Set<Character> rowSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            rowSet.clear();
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if ('.' != c) {
                    if (existInMap(columnMap, j, c)) {
                        return false;
                    } else {
                        Set<Character> set = columnMap.getOrDefault(j, new HashSet<>());
                        set.add(c);
                        columnMap.put(j, set);
                    }
                    if (rowSet.contains(c)) {
                        return false;
                    } else {
                        rowSet.add(c);
                    }

                    Integer boxNumber = getBoxNumber(i, j);
                    if (existInMap(boxMap, boxNumber, c)) {
                        return false;
                    } else {
                        Set<Character> set = boxMap.getOrDefault(boxNumber, new HashSet<>());
                        set.add(c);
                        boxMap.put(boxNumber, set);
                    }
                }
            }
        }
        return true;
    }

    private static Integer getBoxNumber(int i, int j) {
        int boxRow = i / 3;
        int boxCol = j / 3;
        return boxRow * 3 + boxCol + 1;
    }

    private static boolean existInMap(Map<Integer, Set<Character>> map, int j, char c) {
        return map.get(j) != null && map.get(j).contains(c);
    }
}
