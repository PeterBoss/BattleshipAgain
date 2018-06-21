package battleshipagain.implementations;

import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.List;
import java.util.Random;
import battleshipagain.BattleshipPlayer;
import battleshipagain.Board;

/**
 *
 * @author PeterBoss
 */
public class RandomPlayer implements BattleshipPlayer{

    
    @Override
    public void startGame(int playerId) {
        System.out.println("You are player " + playerId);
    }

    @Override
    public void placeShips(List<Ship> ships, Board board) {
        for (int i = 0; i < ships.size(); i++) {
            board.placeShip(new Position(0, i), ships.get(i), true);
        }
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        return validTargets.get(new Random().nextInt(validTargets.size()));
    }

    @Override
    public void endGame(int result) {
        if (result == 0) {
            System.out.println("It was a draw somehow");
        } else {
            System.out.println("Player " + result  +" won");
        }
        
    }
    
}
