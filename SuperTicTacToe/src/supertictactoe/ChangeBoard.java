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
public interface ChangeBoard {
    
    public boolean checkCell(int x, int y);
    
    public void placeCell(int x, int y);
}
