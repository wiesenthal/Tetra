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
    public void askMove() {
        System.out.println("Where would you like to move?");
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
