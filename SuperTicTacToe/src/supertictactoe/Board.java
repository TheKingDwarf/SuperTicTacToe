/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took us 2 hours
 * 
 * This class is for the board. The board checks if there's a win for wither the player or the PC and if there's a draw.
 * 
 * 
 * 
 */

//package
package supertictactoe;
//board class
public class Board {
    //veriable
    private int[][] board = new int[3][3];
    
    //sets board
    public void setBoard(int x, int y, int value){
        this.board[x][y] = value;       
    }
    //clonw the board
    public void cloneBoard(int[][] board){
        this.board = board;
    }
    //get board
    public int[][] getBoard(){
        return this.board;
        
    }
    //check for a draw
    public boolean checkDraw() {
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) { //if there are empty cells there is no tie
                if (board[i][j] == 0)
                    return false;
            }
        
        if (checkWin(1) || checkWin(2)){
            return false;
        }
        return true;
    }
    //checks from horizon, diag, and vert win
    //returns boolean
    public boolean checkWin( int t){
        return checkHorizontalWin(board, t) || checkVerticalWin(board, t) || checkDiagonalWin(board, t);        
    }//end check win
    //checks horizontal win
    //returns boolean
    public boolean checkHorizontalWin(int[][] board, int t){
        for (int i = 0; i < board.length; i++) {
				int count = 0;
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == t)
						count++;
				}
				if (count == 3)
					return true;
			}
			return false;
        
    }//end check horizon
   
    //check win vertically
    //returns boolean
    public boolean checkVerticalWin(int[][] board, int t){
        for (int i = 0; i < board.length; i++) {
				int count = 0;
				for (int j = 0; j < board[i].length; j++) {
					if (board[j][i] == t)
						count++;
				}
				if (count == 3)
					return true;
			}
			return false;
        
    }//end check vert
     //checks diagonal win
    public boolean checkDiagonalWin(int[][] board, int t){
        int count = 0;
			for (int i = 0; i < board.length; i++) {
				if (board[i][i] == t)
					count++;
				if (count == 3)
					return true;
			}

			count = 0;
			for (int i = 0, j = board[i].length - 1; j >= 0 ; j--, i++) {
				if (board[i][j] == t)
					count++;
				if (count == 3)
					return true;
			}
			return false;
        
    }//end check diagonal
    //check double
    //returnsboolean
    public boolean checkDouble( int t) {
        return checkHorizontalDouble(board, t) || checkVerticalDouble(board, t) || checkDiagonalDouble(board, t);
    }
    //checks horizontal win
    public boolean checkHorizontalDouble(int[][] board, int t){
        for (int i = 0; i < board.length; i++) {
				int count = 0;
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == t)
						count++;
				}
				if (count == 2)
					return true;
			}
			return false;
        
    }//end check horizon
   
    //check win vertically
    public boolean checkVerticalDouble(int[][] board, int t){
        for (int i = 0; i < board.length; i++) {
				int count = 0;
				for (int j = 0; j < board[i].length; j++) {
					if (board[j][i] == t)
						count++;
				}
				if (count == 2)
					return true;
			}
			return false;
        
    }//end check vert
     //checks diagonal win
    public boolean checkDiagonalDouble(int[][] board, int t){
        int count = 0;
			for (int i = 0; i < board.length; i++) {
				if (board[i][i] == t)
					count++;
				if (count == 2)
					return true;
			}

			count = 0;
			for (int i = 0, j = board[i].length - 1; j >= 0 ; j--, i++) {
				if (board[i][j] == t)
					count++;
				if (count == 2)
					return true;
			}
			return false;
        
    }//end check diagonal
}//end board class
