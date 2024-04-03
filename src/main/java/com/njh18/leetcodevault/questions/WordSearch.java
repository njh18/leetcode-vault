package com.njh18.leetcodevault.questions;

public class WordSearch {

    int rows;
    int cols;

    int[][] visted;
    String s;
    char[][] b;

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCB");
    }
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        s = word;
        b = board;
        visted = new int[rows][cols];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backTrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(int r, int c, int i) {
        if (i == s.length()) {
            return true;
        }

        if (r >= rows || r < 0 || c >= cols || c < 0
                || s.charAt(i) != b[r][c]
                || visted[r][c] == 1) {
            return false;
        }
        visted[r][c] = 1;
        boolean res = backTrack(r, c + 1, i + 1) ||
                backTrack(r + 1, c, i + 1) ||
                backTrack(r - 1, c, i + 1) ||
                backTrack(r, c - 1, i + 1);
        visted[r][c] = 0;
        return res;
    }

}
