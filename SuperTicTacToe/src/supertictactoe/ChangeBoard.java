/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me 5 minutes
 */
package supertictactoe;

/**
 *
 * @author travis.dutton
 */
public interface ChangeBoard {
    
    public boolean checkCell(int x, int y);
    
    public void placeCell(int x, int y, Board board);
}
