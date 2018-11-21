/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me x hours
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
    //get board
    public int[][] getBoard(){
        return this.board;
        
    }
    //checks from horizon, diag, and vert win
    public boolean checkWin(int[][] board, int t){
        return checkHorizontalWin(board, t) || checkVerticalWin(board, t) || checkDiagonalWin(board, t);        
    }//end check win
    //checks horizontal win
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
    
    
}//end class
