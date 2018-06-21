package remote;

import battleshipagain.Position;
import battleshipagain.Ship;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import battleshipagain.BattleshipPlayer;
import battleshipagain.Board;

/**
 *
 * @author PeterBoss
 */

//used by the server to query the remote player
public class PlayerCallSide implements BattleshipPlayer {

    private final BattleshipConnection conn;

    public PlayerCallSide(BattleshipConnection conn) {
        this.conn = conn;
    }

    @Override
    public void startGame(int playerId) {
        try {
            conn.writeString("playGame");
            conn.writeInt(playerId);
        } catch (IOException ex) {
            Logger.getLogger(PlayerCallSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void placeShips(List<Ship> ships, Board board) {  //difficult, fix later
        for (int i = 0; i < ships.size(); i++) {
            board.placeShip(new Position(0, i), ships.get(i), true);
        }
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        Position pos = null;
        try {
            conn.writeString("takeTurn");
            conn.writeValidTargets(validTargets);
            pos = conn.readPosition();
        } catch (IOException ex) {
            Logger.getLogger(PlayerCallSide.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Position p : validTargets) {  //this is necessary
            if (p.x == pos.x && p.y == pos.y) {
                return p;
            }
        }
        return pos;
        
    }

    @Override
    public void endGame(int result) {
        try {
            conn.writeString("endGame");
            conn.writeInt(result);
        } catch (IOException ex) {
            Logger.getLogger(PlayerCallSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
