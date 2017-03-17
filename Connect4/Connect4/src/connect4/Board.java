/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author 2006184
 */

public class Board {
    private int[][] board = new int[6][7];
    public String getSymbol(int row, int col) {
        switch (board[row][col]) {
            case -1:
                return "O";
            case 1:
                return "●";
            default:
                return "-";
        }
    }
    public String toString() {
        String myBoard = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                myBoard += getSymbol(i,j) + "\t";
            }
            myBoard += "\n";
        }
        return myBoard;
    }
    public boolean checkValid(int col) {
        for (int[] row : board) {
            if (row[col] == 0) {
                return true;
            }
        }
        return false;
    }
    
    //checkWin
    
    //dropDown
    public int dropDown(int col) {
    for (int i= 0; i< board[0].length; i++) {
        if (board[i][col]!= 0 ) {
            return i-1;
        } else {
            return -1;
        }
    
    }
    
   }
}