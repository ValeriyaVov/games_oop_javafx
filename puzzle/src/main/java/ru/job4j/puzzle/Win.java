package ru.job4j.puzzle;

 public class Win {
    public static boolean check(int[][] board) {
    boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
           if (checkRow(board, i) || checkColumn(board, i)) {
               rsl = true;
           }
        }
        return rsl;
    }

 public static boolean checkRow(int[][] board, int row) {
     boolean rsl = true;
     for (int column = 0; column < board[row].length; column++) {
         if (board[row][column] != 1) {
             rsl = false;
             break;
         }
     }
     return rsl;
 }

 public static boolean checkColumn(int[][] board, int column) {
        boolean rsl = true;
        for (int row = 0; row < board.length; row++) {
         if (board[row][column] != 1) {
             rsl = false;
             break;
         }
        }
        return rsl;
    }

}

