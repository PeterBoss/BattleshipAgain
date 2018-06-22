package battleshipagain.implementations;

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
    
    private final BattleshipPlayer player;

    public ProxyPlayer(BattleshipPlayer player) {
        this.player = player;
    }
    
    @Override
    public void startGame(int playerId) {
        player.startGame(playerId);
    }

    @Override
    public void placeShips(List<Ship> ships, Board board) {
        player.placeShips(ships, board);
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        return player.takeTurn(validTargets);
    }

    @Override
    public void endGame(int result) {
        player.endGame(result);
    }
    
}
