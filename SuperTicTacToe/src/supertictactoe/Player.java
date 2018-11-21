/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supertictactoe;

/**
 *
 * @author travis.dutton
 */
public class Player implements ChangeBoard {
    
    Board board = new Board();
    
    public Player(Board board){
        this.board = board;
    }
    
    public void turn(){
        
    }
    
    public boolean checkCell(){
        return false;
        
    }
    
    
    
}//end class
