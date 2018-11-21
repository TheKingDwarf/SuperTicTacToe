/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me x hours
 */

//package
package supertictactoe;

//class implements changeboard
public class Player implements ChangeBoard {
    //veriable
    private int[][] boardData;
    //new object of the board
    Board board = new Board();
    //constructor
    public Player(Board board){
        this.board = board;
    }
    //turn for player
    //return void
    public void turn(){
        
    }
    //checkcell
    //return boolean
    public boolean checkCell(int x, int y){
        getBoard(); //make sure our board data is accurate

        return boardData[x][y] == 0; //returns 1 or 0 based off what this statement evaluates to
    }//end checkcell
    //placecell
    //return void
    public void placeCell(int x, int y) {
        if(checkCell(x, y)) {
            board.setBoard( x, y, 1);
        } 
    }//end placecell
    //getboard 
    //return void
    public void getBoard() {
        this.boardData = board.getBoard();
    }//end getboard
    
}//end class
