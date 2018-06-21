/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import battleshipagain.Position;
import battleshipagain.Ship;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import battleshipagain.Board;

/**
 *
 * @author PeterBoss
 */
public interface BattleshipConnection extends Closeable {

    public String readString() throws IOException;

    public void writeString(String str) throws IOException;

    public int readInt() throws IOException;

    public void writeInt(int playerId) throws IOException;

    public Board readBoard() throws IOException;
    
    public void writeBoard(Board board) throws IOException;

    public List<Ship> readShips() throws IOException;
    
    public void writeShips(List<Ship> ships) throws IOException;

    public List<Position> readValidTargets() throws IOException;

    public void writeValidTargets(List<Position> validTargets) throws IOException;

    public Position readPosition() throws IOException;

    public void writePosition(Position pos) throws IOException;

}
