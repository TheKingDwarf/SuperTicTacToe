/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertictactoe;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/*
TODO:
****************************************************************************
Travis
make cell class
    has variables for its x and y position within the grid
    has two methods, setImage and mouseClick
    reference stackoverflow thread

    error message popup window if player selects a cell that is already taken

//TO DO: use the check cell method to show error message
//selectable image to place token 
//blank is 0, player token is 1, computer token is 2

*****************************************************************************
Logan
program recursive computer ai
make images
*****************************************************************************

*/
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
    
    
    public void setImage(){
        this.getChildren().clear();
       switch (state) {
           case 0: //nothing
                 this.setStyle("-fx-background-color: #000");
                 break;
           case 1: //player
                 this.setStyle("-fx-background-color: #FFF");
                 break;
           case 2:
                 this.setStyle("-fx-background-color: #AAA");
                 break;
       }
    }
    //mouseclick 
    //returns 
    public void mouseClick(){
        if ((state == 0) && (!board.checkWin(1)) && (!board.checkWin(2))) {
            placeCell(x, y, board);
            ai.turn();
            master.updateAll();
        }
    }
   public void update(){
     getBoardData();
     state = boardData[x][y];
     setImage();
   }
}
