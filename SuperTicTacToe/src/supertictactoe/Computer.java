/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me 4 hours
 *
 *
 *
 * This class is the computer class that the player goes up against. It has 3 different
 * difficulties that the user can select from. each increase in difficulty has a higher level of check against possible player moves
 * and computer moves. 
 *
 */
package supertictactoe;
//import
import java.util.ArrayList;
//computer class
public class Computer implements ChangeBoard {
    //veriables
    final int difficulty;
    private boolean cellPlaced = false;
    
    Board board = new Board();//new board object - board
    Board testBoard = new Board();//new board objext - testboard
    private int[][] boardData;
    
    //computer constructor
    //to set board and difficulty 
    public Computer(Board board, int difficulty){
        this.board = board;
        this.difficulty = difficulty;
    }
    //turn, run our turn action based off difficulty. 
    //returns void
    public void turn(){
        switch (difficulty) { //do different things based of difficulty setting
            case 0:
                PlaceCellSmart1Deep(); //really easy
                break;
            case 1:
                PlaceCellSmart3Deep();//hard
                break;
            case 2:
                PlaceCellSmart9Deep();//impossible
                break;
            
        }
    }//end turn
    //computer looks at its current move, if it has winning move it will take it
    //returns void
   public void PlaceCellSmart1Deep() {
       int[] cell = minMax(board, 3, 2);
       if ((cell[0] >= 0) && (cell[1] >= 0))
       placeCell(cell[0], cell[1], board);        
    }
    //place cell for the computer's move 3 deep 
    //returns void
    public void PlaceCellSmart3Deep() {
       int[] cell = minMax(board, 3, 2);
       if ((cell[0] >= 0) && (cell[1] >= 0))
       placeCell(cell[0], cell[1], board);        
    }
    //place cell for the computer's move 9 deep
    //looks at every possible move, computer is looking at the end of the game when making its first move
    //returns void
    public void PlaceCellSmart9Deep() {
       int[] cell = minMax(board, 9, 2);
       if ((cell[0] >= 0) && (cell[1] >= 0))       
       placeCell(cell[0], cell[1], board);   
    }
    /**
     * minMax finds the best moves for the computer to make
     * 
     * @param board
     * @param depth
     * @param token
     * @return int[] x, y and score
     * 
     * uses minMax algorithm
     */
    public int[] minMax(Board board, int depth, int token) {
        ArrayList<int[]> possibleMoves = findMoves(board);
        
        //are we minimizing, or maximising the score ie are we checking the players moves or the computers
        //if we are minimizing, this = -infinity; otherwise this is the same as infinity
        int bestScore = (token == 2) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;
        int oppToken = (1 - (token - 1))+1;
 
        //if there are no more moves to take along this tree, or we out of depth
        if (possibleMoves.isEmpty() || depth == 0) {
            bestScore = evaluateBoardState(board);  
        } else {
            //iterate through all the moves
            for (int[] move: possibleMoves) {
                //Board testBoard = new Board();
                //copy board data to the test instance
                //testBoard.cloneBoard(board.getBoard());
                board.setBoard(move[0],move[1],token);
                
                if (token == 2) { //if we are computer
                    currentScore = minMax(board, depth-1, oppToken)[2];
                    
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = move[0]; //this is the x coord
                        bestCol = move[1]; // y coord
                    }
                } else {
                   currentScore = minMax(board, depth-1, oppToken)[2];
                    //if we are looking from the players perspective
                    //we want the crappy moves, aka the ones where the pc wins
                    if (currentScore < bestScore) { 
                        bestScore = currentScore;
                        bestRow = move[0]; //this is the x coord
                        bestCol = move[1]; // y coord
                    } 
                }
                board.setBoard(move[0],move[1],0);//undo the move we made
            }
            
        }

        
        return new int[] {bestRow, bestCol, bestScore};
        
        
    }
    /**
     * evaluates board state based off certain factors
     * @param board
     * @return score
     */
    public int evaluateBoardState(Board board) {
        int score = 0;
        if (board.checkDouble(2)) score = 10;
        if (board.checkDouble(1)) score = -10;
        if (board.checkWin(2)) score = 100;
        if (board.checkWin(1)) score = -100;
        if (board.checkDraw()) score = 0;
        return score;
    }
    /**
     * findMoves
     * @param board
     * @return listOfMoves
     */
    public ArrayList<int[]> findMoves(Board board) {
        ArrayList<int[]> list = new ArrayList<>();
        int[][] bData = board.getBoard();
        
        if (board.checkWin(1) || board.checkWin(2)) return list;//if someones run return empty list
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (bData[i][j] == 0){
                    list.add(new int[] {i, j});
                }
            }
        
        return list;
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
