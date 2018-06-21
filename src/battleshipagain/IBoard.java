package battleshipagain;

import java.util.List;

/**
 *
 * @author PeterBoss
 */
public interface IBoard {
    public boolean checkForGameOver();
    public void placeShip(Position p, Ship s, Boolean vert);
    public int placeShot(Position p);
    public List<Position> getValidTargets();
    public int remainingTargets();
    public int sizeX();
    public int sizeY();
}
