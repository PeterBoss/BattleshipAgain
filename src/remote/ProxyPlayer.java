package remote;

import battleshipagain.IBoard;
import battleshipagain.IPlayer;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.List;

/**
 *
 * @author PeterBoss
 */
public class ProxyPlayer implements IPlayer{
    
    IPlayer actualPlayer = null;
    
    
    
    @Override
    public void playGame(int playerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void placeShips(List<Ship> ships, IBoard board) {
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
