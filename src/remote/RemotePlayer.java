package remote;

import battleshipagain.IPlayer;
import battleshipagain.Position;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author PeterBoss
 */
public class RemotePlayer implements Runnable {

    private final BattleshipConnection conn;
    private final IPlayer player;

    public RemotePlayer(BattleshipConnection conn, IPlayer player) {
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
                        player.playGame(id);
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
