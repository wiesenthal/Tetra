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
    
    //declare independence
    public boolean independence;
    
    private int[][] board = new int[8][8];
    public Board() {
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++) {
                board[i][j] = 0;
            }
        }
    }
    public Board(int[][] b) {
        board = b;
    }
    public int[][] getBoard() {
        return board;
    }
    public String getSymbol(int row, int col) {
        switch (board[row][col]) {
            case -1:
                return "O";
            case 1:
                return "X";
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
        if (board[0][col] == 0) {
            return true;
        }
        return false;
    }
    
    public void makeMove(int col,int playerType) {
        if (checkValid(col)) {
            board[dropDown(col)][col] = playerType;
        }
    }
    
    public boolean checkWin(int playerSymbol) {
        //check horizontal
        int consecutive = 0;
        for (int i = 0; i < board.length; i++) {
            consecutive = 0;
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
            consecutive = 0;
            for (int j = 0; j < board.length; j++) {
                if (consecutive == 3) {
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
        consecutive = 0;
        //check diagonal top down part 1
        for (int i = 7; i > 0; i -- ) {
            consecutive = 0;
            for (int j = 0; j < 7-i; j ++) {
                if (consecutive == 4) {
                    return true;
                }
                if (board[j][j+i] == playerSymbol) {
                    consecutive += 1;
                }
                else {
                    consecutive = 0;
                }
            }
        }
        
        consecutive = 0;
        //check diagonal top down part 2
        for (int i = 0; i > 7; i ++ ) {
            consecutive = 0;
            for (int j = 0; j < 7-i; j ++) {
                if (consecutive == 4) {
                    return true;
                }
                if (board[j+i][j] == playerSymbol) {
                    consecutive += 1;
                }
                else {
                    consecutive = 0;
                }
            }
        }
        consecutive = 0;
        //check diagonal bot up part 1
        for (int i = 7; i > 0; i -- ) {
            consecutive = 0;
            for (int j = 7; j > i; j --) {
                if (consecutive == 4) {
                    return true;
                }
                if (board[j][7+(i - j)] == playerSymbol) {
                    consecutive += 1;
                }
                else {
                    consecutive = 0;
                }
            }
        }
        consecutive = 0;
        //check diagonal bot up part 2
        for (int i = 0; i < 7; i ++) {
            consecutive = 0;
            for (int j = 0; j < i; j ++) {
                if (consecutive == 4) {
                    return true;
                }
                if (board[(i - j)][j] == playerSymbol) {
                    consecutive += 1;
                }
                else {
                    consecutive = 0;
                }
            }
        }
        return false;
    }
    
    public int dropDown(int col) {
    for (int i= 0; i< board[0].length; i++) {
        if (board[i][col]!= 0 ) {
            return i-1;
        }
        }
    return 7;
    }
    
}