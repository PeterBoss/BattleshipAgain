package battleshipagain;

import java.util.List;

/**
 *
 * @author PeterBoss
 */
public interface BattleshipPlayer {
    public void startGame(int playerId);
    public void placeShips(List<Ship> ships, Board board);
    public Position takeTurn(List<Position> validTargets);
    public void endGame(int result);
}
