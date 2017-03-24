package connect4;

/**
 *
 * @author 2006184
 */
public class Connect4 {

    public static void main(String[] args) {
        // TODO code application logic here
        Board board = new Board();
        Player p1 = new Player(1, board);
        Player p2 = new Player(-1, board);
        int turn = 0;
        while(true){
            if (board.checkValid(p1.playerNum)) {
                System.out.println("Player1 Wins");
                break;
            }
            else if (board.checkValid(p2.playerNum)) {
                System.out.println("Player2 Wins");
                break;
            }
            else {
                if (turn % 2 == 0) {
                    p1.askMove();
                }
                else {
                    p2.askMove();
                }
            }
        }
    }

    
}