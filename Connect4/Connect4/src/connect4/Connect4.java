package connect4;


 

/**
 *
 * @author 2006184
 */
public class Connect4 {

    public static void main(String[] args) throws Exception {
        Sound wow = new Sound("wow.wav");
        Sound sorry1 = new Sound("sorry.wav");
        Sound win = new Sound("hooray.wav");
        Sound which = new Sound("which.wav");
        wow.play();
        // TODO code application logic here
        Board board = new Board();
        Player p1 = new Player(1, board);
        Player p2 = new Player(-1, board);
        int turn = 1;
        while(true){
            if (board.checkWin(p1.getPlayerNum())) {
                win.play();
                System.out.println(board);
                System.out.println("Player 1 Wins");
                break;
            }
            else if (board.checkWin(p2.getPlayerNum())) {
                sorry1.play();
                System.out.println(board);
                System.out.println("Player 2 Wins");
                break;
            }
            else {
                which.play();
                System.out.println(board);
                turn+=1;
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