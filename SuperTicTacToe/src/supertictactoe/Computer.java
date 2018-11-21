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
public class Computer implements ChangeBoard {
    
    private int difficulty;
    
    Board board = new Board();
    Board testBoard = new Board();
    
    
    
    public Computer(Board board, int difficulty){
        this.board = board;
        this.difficulty = difficulty;
    }
    
    public void turn(){
        
    }
    
    public boolean checkCell(){
        return false;
        
    }
    
    
}
