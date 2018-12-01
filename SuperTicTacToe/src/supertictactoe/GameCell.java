/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took us 3 hours
 */
package supertictactoe;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;


public class GameCell extends StackPane implements ChangeBoard{
    int x;
    int y;
    int[][] boardData;
    int state;
    Computer ai;
    
    Board board;
    
    SuperTicTacToe master;
    
    public GameCell( int y, int x, Board board, Computer ai, SuperTicTacToe master) {
        super();
        this.x = x;
        this.y = y;
        this.board = board;  
        this.ai = ai;
        this.setOnMouseClicked(e -> mouseClick());
        this.master = master;

    }
     //checkcell
    //return boolean
    @Override
    public boolean checkCell(int x, int y){
        getBoardData(); //make sure our board data is accurate

        return boardData[x][y] == 0; //returns 1 or 0 based off what this statement evaluates to
    }//end checkcell
    
    //placecell
    //return void
    @Override
    public void placeCell(int x, int y, Board board) {
        if(checkCell(x, y)) {
            board.setBoard( x, y, 1);
        } 
    }//end placecell
    
    //getboard 
    //return void
    public void getBoardData() {      
        this.boardData = board.getBoard();
    }//end getboard
    
    /**
     * set the look of this cell based off state
     */
    public void setImage(){
        this.getChildren().clear();
       switch (state) {
           case 0: //nothing
                 this.setStyle("-fx-background-color: #d2aa99; -fx-border-color: #d27d2c; -fx-border-radius: 5;");
               
                 break;
           case 1: //player
                 this.setStyle("-fx-background-color: #d04648;");
                 Label X = new Label("X");
                 X.setStyle("-fx-font-size: 72pt; -fx-font-family: 'Open-sans', sans-serif;");
                 this.getChildren().add(X);   
                 break;                              
           case 2:
                 this.setStyle("-fx-background-color: #597dce;");
                 Label o = new Label("O");
                 o.setStyle("-fx-font-size: 72pt; -fx-font-family: 'Open-sans', sans-serif;");
                 this.getChildren().add(o);
                 break;
       }
    }
    //mouseclick 
    //returns 
    public void mouseClick(){
        if ((state == 0) && (!board.checkWin(1)) && (!board.checkWin(2))) {
            placeCell(x, y, board);
            ai.turn();
            master.updateAll();//update every single cell
        }
    }
   public void update(){ //update this cell
     getBoardData();
     state = boardData[x][y];
     setImage();
   }
}
