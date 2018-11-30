/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertictactoe;

import javafx.scene.layout.Pane;

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
    Computer ai;
    
    Board board;

    public Cell(int x, int y, Board board, Computer ai) {
        this.x = x;
        this.y = y;
        this.board = board;  
        this.ai = ai;
        this.setOnMouseClicked(e -> mouseClick());
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
           
    }
    //mouseclick 
    //returns 
    public void mouseClick(){
        placeCell(x, y, board);
        ai.turn();
    }
   
}
