/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptations;

import battleship.interfaces.Board;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;

/**
 *
 * @author Peter
 */
public class DummyBoard implements Board{

    private int x;
    private int y;

    DummyBoard(int sizeX, int sizeY) {
        x = sizeX;
        y = sizeY;
    }
    
    @Override
    public int sizeX() {
        return x;
    }

    @Override
    public int sizeY() {
        return y;
    }

    @Override
    public void placeShip(Position pos, Ship ship, boolean vertical) {
    }
    
}
