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
import javafx.scene.paint.Color;
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
public class GameCell extends Pane implements ChangeBoard{
    int x;
    int y;
    private int[][] boardData;
    int state;
    Computer ai;
    
    Board board;
    
    public GameCell(int x, int y, Board board, Computer ai) {
        this.x = x;
        this.y = y;
        this.board = board;  
        this.ai = ai;
        this.setOnMouseClicked(e -> mouseClick());
        this.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());

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
        this.getChildren().clear();
       switch (state) {
           case 0: //nothing
               break;
           case 1: //player
               Line line1 = new Line(10, 10, 
                this.getWidth() - 10, this.getHeight() - 10);
              line1.endXProperty().bind(this.widthProperty().subtract(10));
              line1.endYProperty().bind(this.heightProperty().subtract(10));
              Line line2 = new Line(10, this.getHeight() - 10, 
                this.getWidth() - 10, 10);
              line2.startYProperty().bind(
                this.heightProperty().subtract(10));
              line2.endXProperty().bind(this.widthProperty().subtract(10));

              // Add the lines to the pane
              this.getChildren().addAll(line1, line2); 
               break;
           case 2:
               Ellipse ellipse = new Ellipse(this.getWidth() / 2, 
                this.getHeight() / 2, this.getWidth() / 2 - 10, 
                this.getHeight() / 2 - 10);
              ellipse.centerXProperty().bind(
                this.widthProperty().divide(2));
              ellipse.centerYProperty().bind(
                  this.heightProperty().divide(2));
              ellipse.radiusXProperty().bind(
                  this.widthProperty().divide(2).subtract(10));        
              ellipse.radiusYProperty().bind(
                  this.heightProperty().divide(2).subtract(10));   
              ellipse.setStroke(Color.BLACK);
              ellipse.setFill(Color.WHITE);

              getChildren().add(ellipse); // Add the ellipse to the pane
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
