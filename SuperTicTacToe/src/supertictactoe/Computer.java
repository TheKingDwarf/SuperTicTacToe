/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertictactoe;

/**
 *
 * @author travis.dutton
 */
public class Computer implements ChangeBoard {
    
    private int difficulty;
    
    Board board = new Board();
    Board testBoard = new Board();
    private int[][] boardData;
    
    
    public Computer(Board board, int difficulty){
        this.board = board;
        this.difficulty = difficulty;
    }
    
    public void turn(){
        
    }
    
    public boolean checkCell(int x, int y){
        getBoard(); //make sure our board data is accurate

        return boardData[x][y] == 0; //returns 1 or 0 based off what this statement evaluates to
        
    }
    
    public void placeCell(int x, int y) {
        if(checkCell(x, y)) {
            board.setBoard( x, y);
        } 
    }
            
    public void getBoard() {
        this.boardData = board.getBoard();
    }
    
    
    
}
