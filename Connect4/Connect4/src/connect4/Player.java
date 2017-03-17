package connect4;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2006893
 */
public class Player {
    private Board theBoard;
    public void askMove() {
        System.out.println("What row would you like to place a tile?");
        Scanner scan = new Scanner(System.in);
        int move = scan.nextInt();
        theBoard.checkValid(move);
        if (theBoard.checkValid(move)) {
            //theBoard.makeMove();
        }
        else {
            System.out.println("Invalid Position. Choose again.");
        }
    }
}
