package battleshipagain;

import java.util.List;

/**
 *
 * @author PeterBoss
 */
public interface IPlayer {
    public void playGame(int playerId);
    public void placeShips(List<Ship> ships, IBoard board);
    public Position takeTurn(List<Position> validTargets);
    public void endGame(int result);
}
