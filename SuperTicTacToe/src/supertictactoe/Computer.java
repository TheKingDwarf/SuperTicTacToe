/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me x hours
 */
package supertictactoe;

import java.util.Random;

/**
 *
 * @author travis.dutton
 */
public class Computer implements ChangeBoard {
    
    private int difficulty;
    private boolean cellPlaced = false;
    
    Board board = new Board();
    Board testBoard = new Board();
    private int[][] boardData;
    
    
    public Computer(Board board, int difficulty){
        this.board = board;
        this.difficulty = difficulty;
    }
    
    public void turn(){
        switch (difficulty) { //do different things based of difficulty setting
            case 0:
                PlaceRandomCell(); //really easy
                break;
            case 1:
                PlaceCellSmart3Deep();//hard
                break;
            case 2:
                PlaceCellSmart5Deep();//impossible
                break;
            
        }
    }
    
    public void PlaceRandomCell() {
        Random rand = new Random();//new random instance
        cellPlaced = false; 
        
        while (cellPlaced = false) { //generate random positions until one works
            placeCell(rand.nextInt(2),rand.nextInt(2));
        }
    }
    
    public void PlaceCellSmart3Deep() {
    }
    
    public void PlaceCellSmart5Deep() {
    }


    @Override
    public boolean checkCell(int x, int y){
        getBoard(); //make sure our board data is accurate

        return boardData[x][y] == 0; //returns 1 or 0 based off what this statement evaluates to
        
    }
    
    @Override
    public void placeCell(int x, int y) {
        if(checkCell(x, y)) { //if cell is empty
            board.setBoard( x, y, 2); //set the cell at the board
            cellPlaced = true; //break out of loop
        } 
    }
            
    public void getBoard() {
        this.boardData = board.getBoard();
    }
    
    
    
}
