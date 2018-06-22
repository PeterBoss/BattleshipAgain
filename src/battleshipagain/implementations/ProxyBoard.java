/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipagain.implementations;

import battleshipagain.Board;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.List;

/**
 *
 * @author Peter
 */
public class ProxyBoard implements Board{
    
    private final Board board;

    public ProxyBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean checkForGameOver() {
        return board.checkForGameOver();
    }

    @Override
    public void placeShip(Position p, Ship s, Boolean vert) {
        board.placeShip(p, s, vert);
    }

    @Override
    public int placeShot(Position p) {
        return board.placeShot(p);
    }

    @Override
    public List<Position> getValidTargets() {
        return board.getValidTargets();
    }

    @Override
    public int remainingTargets() {
        return board.remainingTargets();
    }

    @Override
    public int sizeX() {
        return board.sizeX();
    }

    @Override
    public int sizeY() {
        return board.sizeY();
    }
    
}
