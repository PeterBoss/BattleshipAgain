package remote;

import battleshipagain.Position;
import java.io.IOException;
import java.util.List;
import battleshipagain.BattleshipPlayer;

/**
 *
 * @author PeterBoss
 */

//used by the client to interpret commands coming from the server
public class PlayerImplementationSide implements Runnable {

    private final BattleshipConnection conn;
    private final BattleshipPlayer player;

    public PlayerImplementationSide(BattleshipConnection conn, BattleshipPlayer player) {
        this.conn = conn;
        this.player = player;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String methodName = conn.readString();
                switch (methodName) {
                    case "playGame":
                        int id = conn.readInt();
                        player.startGame(id);
                        break;
                    case "placeShips":  //later
//                        IBoard board = conn.readBoard();
//                        List<Ship> ships = conn.readShips();
//                        player.placeShips(ships, board);
                        break;
                    case "takeTurn":
                        List<Position> validTargets = conn.readValidTargets();
                        Position pos = player.takeTurn(validTargets);
                        conn.writePosition(pos);
                        break;
                    case "endGame":
                        int result = conn.readInt();
                        conn.close();
                        player.endGame(result);
                        return;
                    default:
                        throw new RuntimeException("Unknown method: " + methodName);
                }

            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
