package adaptations;

import battleshipagain.Board;
import battleship.interfaces.Fleet;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import test16.TestPlayer;
import battleshipagain.BattleshipPlayer;
import java.util.Random;

/**
 *
 * @author Peter
 */
public class OldPlayerAdapter implements BattleshipPlayer {

    private TestPlayer player = new TestPlayer();

//    private PrintStream originalStream = System.out;
//    private PrintStream dummyStream = new PrintStream(new OutputStream() {
//        public void write(int b) {
//            // nothing 
//        }
//    });

    public OldPlayerAdapter() {
    }

    @Override
    public void startGame(int playerId) {
//        System.setOut(dummyStream);
        player.startRound(0);

    }

    @Override
    public void placeShips(List<Ship> ships, Board board) {

        Fleet fleet = new AdaptionFleet(ships);
        battleship.interfaces.Board dummyBoard = new DummyBoard(board.sizeX(), board.sizeY()); 
        player.placeShips(fleet, dummyBoard); //the old player uses this to re-initialize a lot of things, but actually making it place the ships is a big project in itself
        //placing in the corner. 
        for (int i = 0; i < ships.size(); i++) {
            board.placeShip(new Position(0, i), ships.get(i), true);
        }

    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        //this is the tough one. the new api just doesn't give fleet info (it propably should)
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
//        System.setOut(originalStream);
        player.endRound(0, 0, 0);
    }

    private Fleet generateEnemyFleet() { //stop-gap solution. it works, but it doesn't win games

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
