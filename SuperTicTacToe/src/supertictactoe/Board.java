
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
    
    public int[][] getBoard(){
        return this.board;
        
    }
    //checks from horizon, diag, and vert win
    public boolean checkWin(int[][] board, int t){
        return checkHorizontalWin(board, t) || checkVerticalWin(board, t) || checkDiagonalWin(board, t);        
    }
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
        
    }
   
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
        
    }
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
        
    }
    
    
}//end class
