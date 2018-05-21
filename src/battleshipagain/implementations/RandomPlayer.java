package battleshipagain.implementations;

import battleshipagain.IBoard;
import battleshipagain.IPlayer;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PeterBoss
 */
public class RandomPlayer implements IPlayer{

    private int playerId;
    
    @Override
    public void playGame(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public void placeShips(List<Ship> ships, IBoard board) {
        for (int i = 0; i < ships.size(); i++) {
            board.placeShip(new Position(0, i), ships.get(i), Boolean.TRUE);
        }
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        return validTargets.get(new Random().nextInt(validTargets.size()));
    }

    @Override
    public void endGame(int result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
