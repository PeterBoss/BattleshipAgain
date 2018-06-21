package remote;

import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.List;
import battleshipagain.BattleshipPlayer;
import battleshipagain.Board;

/**
 *
 * @author PeterBoss
 */
public class ProxyPlayer implements BattleshipPlayer{
    
    BattleshipPlayer actualPlayer = null;
    
    
    
    @Override
    public void startGame(int playerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void placeShips(List<Ship> ships, Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endGame(int result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
