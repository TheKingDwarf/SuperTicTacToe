/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        switch (difficulty) {
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
        Random rand = new Random();
        cellPlaced = false;
        while (cellPlaced = false) {
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
        if(checkCell(x, y)) {
            board.setBoard( x, y, 2);
            cellPlaced = true;
        } 
    }
            
    public void getBoard() {
        this.boardData = board.getBoard();
    }
    
    
    
}
