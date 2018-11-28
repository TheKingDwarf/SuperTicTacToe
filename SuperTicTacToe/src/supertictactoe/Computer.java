/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me x hours
 */
package supertictactoe;

import java.util.ArrayList;
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
            placeCell(rand.nextInt(2),rand.nextInt(2), board);
        }
    }
    
    public void PlaceCellSmart3Deep() {
       
        
    }
    
    public void PlaceCellSmart5Deep() {
    }
    
    public int[] findCellSmart(Board board, int depth, int score, int token) {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        int[] foundCell;
        int[][] b = board.getBoard(); //get the numerical data
        
        //loop through array, listing all empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; i++) {
                if (b[i][j] == 0) {
                    int[] temp = {i, j};
                    possibleMoves.add(temp);
                }
            }
        }  
        //loop through all of those
        for (int i = 0; i < possibleMoves.size(); i++){
            Board testBoard = new Board();//for each one make a new board
            testBoard.cloneBoard(board.getBoard());//set the boards data equal to the current board
            
            //place a token into the 
            int[] cell = possibleMoves.get(i); //get the cell from list of possibilities
            placeCell(cell[0], cell[1], testBoard);//place a cell at those coords
            
            //Analyze Board
            if (testBoard.checkWin(token)) {
                score += 10000;
                depth = 0;
            }
            
            if (testBoard.checkWin(1 + (2 - token))) { //check if enemy won
                score -= 10000;
                depth = 0;//we've reached a terminal board, no more recursions neccesary
            }
            
            if (testBoard.checkDraw()) {
                score -= 1000;
            }
            
            if (testBoard.checkDouble(token)){
                score += 10;
            }
            
            if (testBoard.checkDouble(1 + (2 - token))) {
                score -= 10;
            }
            
            //RECURSION
            if (depth > 0) {
                foundCell = findCellSmart(testBoard, depth-1, score, 1 + (2 - token));
            } else {
                return new int[] {cell[0], cell[1], score};
            }
        }
        
        return foundCell;
    }

    @Override
    public boolean checkCell(int x, int y){
        getBoard(); //make sure our board data is accurate

        return boardData[x][y] == 0; //returns 1 or 0 based off what this statement evaluates to
        
    }
    
    @Override
    public void placeCell(int x, int y, Board board) {
        if(checkCell(x, y)) { //if cell is empty
            board.setBoard( x, y, 2); //set the cell at the board
            cellPlaced = true; //break out of loop
        } 
    }
            
    public void getBoard() {
        this.boardData = board.getBoard();
    }
    
    
    
}
