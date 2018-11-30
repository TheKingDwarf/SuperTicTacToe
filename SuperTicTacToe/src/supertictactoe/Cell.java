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
import javafx.scene.shape.Ellipse;

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
public class Cell extends Pane implements ChangeBoard{
    int x;
    int y;
    private int[][] boardData;
    int state;
    Computer ai;
    
    Board board;
    public static PseudoClass IS_AI_TOKEN = PseudoClass.getPseudoClass("empty");
    public static PseudoClass IS_PLAYER_TOKEN = PseudoClass.getPseudoClass("isPlayerToken"); 
    
    BooleanProperty isAIToken;
    BooleanProperty isPlayerToken;
    
    public Cell(int x, int y, Board board, Computer ai) {
        this.x = x;
        this.y = y;
        this.board = board;  
        this.ai = ai;
        this.setOnMouseClicked(e -> mouseClick());
        isAIToken = new SimpleBooleanProperty(false);
        isAIToken.addListener(e -> pseudoClassStateChanged(IS_AI_TOKEN, isAIToken.get()));
        isPlayerToken = new SimpleBooleanProperty(false);
        isPlayerToken.addListener(e -> pseudoClassStateChanged(IS_PLAYER_TOKEN, isPlayerToken.get()));
    }
    //getters and setters for properties
    public void setIsAIToken(boolean empty) {
        this.isAIToken.set(empty);
    }

    public boolean isIsAIToken() {
        return this.isAIToken.get();
    }
    public void setIsPlayerToken(boolean empty) {
        this.isPlayerToken.set(empty);
    }

    public boolean isIsPlayerToken() {
        return this.isPlayerToken.get();
    }
     //checkcell
    //return boolean
    @Override
    public boolean checkCell(int x, int y){
        getBoard(); //make sure our board data is accurate

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
    public void getBoard() {
        this.boardData = board.getBoard();
    }//end getboard
    
    
    public void setImage(){
       switch (state) {
           case 0: //nothing
               setIsPlayerToken(false);
               setIsAIToken(false);
               break;
           case 1: //player
               setIsPlayerToken(true);
               setIsAIToken(false);
               Ellipse ellipse = new Ellipse();
               break;
           case 2:
               setIsPlayerToken(false);
               setIsAIToken(true);
               break;//computer
       }
    }
    //mouseclick 
    //returns 
    public void mouseClick(){
        placeCell(x, y, board);
        ai.turn();
    }
   
}
