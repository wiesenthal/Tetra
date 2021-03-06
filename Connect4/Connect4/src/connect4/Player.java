/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;
import java.util.Scanner;
/**
 *
 * @author 2006663
 */
public class Player {
    
    int playerNum; //-1 or 1
    private Board theBoard;
    
    public Player(int pType, Board b) {
        playerNum = pType; // 1 for player 1, -1 for player 2
        theBoard = b;
    }
    public void askMove() {
        if (playerNum==2) {
            theBoard.makeMove((aiMove(theBoard.getBoard(), -1)+20)*-1, -1);
        } else {
            System.out.println("Which column would you like to move in?");
            Scanner scan = new Scanner(System.in);
            int col = scan.nextInt();
            if (theBoard.checkValid(col)) {
                theBoard.makeMove(col, playerNum);
            }
            else {
            System.out.println("Invalid move, different spot?");
            }
        }
    }
    private int aiMove(int[][] bort, int num) { //num is which player it is
        Board board = new Board(bort);
        if (board.checkWin(num)) { //AI wins
            return num;
        }
        else if (board.checkWin(num*-1)) { //Player wins
            return num*-1;
        }
        else { //Not base case
            int[] slots = new int[8];
            for (int i = 0; i < slots.length; i++) {
                
                // if the column is full, make it unusable
                if (!board.checkValid(i)) {
                    slots[i] = -2;
                }
                //for ai best move
                if (slots[i] != -2) { 
                    slots[i] = aiMove(testBoard(i, num, bort), num*-1);     
                }
                
            }
            if (num == 1) {
                for (int i = 0; i < slots.length; i++) {
                    if (slots[i] >= 1) {
                        return (i + 20);
                    }
                    
                }
                return (-1);
            }
            if (num == -1) {
                for (int i = 0; i < slots.length; i++) {
                    if (slots[i] <= -1) {
                        return (-1*i - 20);
                    }
                    
                }
                return (1);
            }
            else {
                return (0);
            }
        }
    }
    
    //creates a theoretical boardstate
    private int[][] testBoard(int col, int p, int[][] bort) {
        Board board = new Board(bort);
        board.makeMove(col, p);
        return board.getBoard();
    }
}