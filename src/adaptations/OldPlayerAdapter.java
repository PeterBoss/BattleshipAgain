
package adaptations;

import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleshipagain.IBoard;
import battleshipagain.IPlayer;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.ArrayList;
import java.util.List;
import test16.TestPlayer;

/**
 *
 * @author Peter
 */
public class OldPlayerAdapter implements IPlayer {

    
    
    TestPlayer player;

    public OldPlayerAdapter() {

        player = new TestPlayer();
        
    }
    
    @Override
    public void playGame(int playerId) {
        player.startRound(playerId);
    }

    @Override
    public void placeShips(List<Ship> ships, IBoard board) {

        Fleet fleet = new AdaptionFleet(ships);
        Board brd = new DummyBoard(board.sizeX(), board.sizeY());
        player.placeShips(fleet, brd);
        
        for (int i = 0; i < ships.size(); i++) {
            board.placeShip(new Position(0, i), ships.get(i), true);
        }
        
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        
        battleship.interfaces.Position pos = player.getFireCoordinates(generateEnemyFleet());
        
        Position target = null;
        
        for (Position p : validTargets) {
            if (p.x == pos.x && p.y == pos.y) {
                target = p;
            }
        }
        return target;
    }

    @Override
    public void endGame(int result) {
        player.endRound(0, 0, 0);
    }
    
    
    private Fleet generateEnemyFleet() {
        
        List<Ship> ships = new ArrayList();
        ships.add(new Ship(5));
        ships.add(new Ship(5));
        ships.add(new Ship(4));
        ships.add(new Ship(4));
        ships.add(new Ship(3));
        ships.add(new Ship(2));
        
        return new AdaptionFleet(ships);
    }
}
