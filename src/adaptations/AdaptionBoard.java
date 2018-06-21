/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptations;

import battleship.interfaces.Board;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;
import battleshipagain.IBoard;

/**
 *
 * @author Peter
 */
public class AdaptionBoard implements Board {

    private IBoard board;
    
    AdaptionBoard(IBoard board) {
        this.board = board;
    }
    
    @Override
    public int sizeX() {
        return board.sizeX();
    }

    @Override
    public int sizeY() {
        return board.sizeY();
    }

    @Override
    public void placeShip(Position pos, Ship ship, boolean vertical) {
        
        battleshipagain.Position p = new battleshipagain.Position(pos.x, pos.y);
        battleshipagain.Ship s = new battleshipagain.Ship(ship.size());
        board.placeShip(p, s, vertical);
        
    }
    
}
