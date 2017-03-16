package connect4;

/**
 *
 * @author 2006184
 */
public class Connect4 {

    private int[][] board = new int[6][7];
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public int[][] getBoard(){
        return board;
    }
    
    public String stringBoard() {
        String myBoard = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                myBoard += getSymbol(i,j) + "\t";
            }
            myBoard += "\n";
        }
        return myBoard;
    }
    
    //askMove1
    
    //askMove2
    
    //checkValid
    
    //checkWin
    
    public String getSymbol(int row, int col) {
        switch (board[row][col]) {
            case 0:
                return "-";
            case -1:
                return "O";
            case 1:
                return "●";
        }
    }
}