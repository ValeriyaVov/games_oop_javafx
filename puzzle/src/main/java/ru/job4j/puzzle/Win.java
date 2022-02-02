package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (checkRow(board[i])) {
                return true;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if(checkColumn(board, j)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkRow(int[] row) {
        boolean rsl = true;
        for (int i = 0; i < row.length ; i++) {
            if (row[i] != 1) {
                rsl = false;
            }
        }
        return rsl;
    }


    public static boolean checkColumn(int[][] board, int column) {
        boolean rsl = true;

        for (int i = 0; i < board.length ; i++) {
            if (board[i][column] != 1) {
                rsl = false;
            }
        }
        return rsl;
    }
}


