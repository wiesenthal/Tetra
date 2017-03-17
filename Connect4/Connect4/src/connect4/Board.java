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
    
    public boolean checkWin(int playerSymbol) {
        //check horizontal
        int consecutive = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (consecutive == 4) {
                    return true;
                }
                if (board[i][j] == playerSymbol) {
                    consecutive +=1;
                }
                
                else {
                    consecutive = 0;
                }
            }
        }
        consecutive = 0;
        //check vertical
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (consecutive == 4) {
                    return true;
                }
                if (board[j][i] == playerSymbol) {
                    consecutive += 1;
                }
                else {
                    consecutive = 0;
                }
            }
        }
        //check diagonal top down
        int[] diagTopDown;
        int[] diagBotUp;
    }
    
    //dropDown
    
}
