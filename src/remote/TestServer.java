package remote;

import battleshipagain.Ship;
import battleshipagain.implementations.StandardGameControl;
import dk.tobiasgrundtvig.util.socket.ConnectionHandler;
import dk.tobiasgrundtvig.util.socket.SocketConnection;
import dk.tobiasgrundtvig.util.socket.impl.Server;
import java.util.ArrayList;
import java.util.List;
import battleshipagain.BattleshipPlayer;
import battleshipagain.GameControl;

/**
 *
 * @author PeterBoss
 */
public class TestServer implements ConnectionHandler {

    private PlayerCallSide p1;
    
    public static void main(String[] args) {
        Server server = new Server(new TestServer(), 3456);
        server.run();
    }

    public TestServer() {
        p1 = null;
    }

    @Override
    public void handleConnection(SocketConnection conn) {
        System.out.println("Handling new connection");
        if (p1 == null) {
            p1 = new PlayerCallSide(new BattleshipConnectionImpl(conn));
        } else {
            PlayerCallSide p2 = new PlayerCallSide(new BattleshipConnectionImpl(conn));
            
            List<Ship> ships = new ArrayList();
            ships.add(new Ship(5));
            ships.add(new Ship(4));
            ships.add(new Ship(3));
            ships.add(new Ship(3));
            ships.add(new Ship(2));
            
            GameControl game = new StandardGameControl(ships, 10, 10);
            
            BattleshipPlayer tmp = p1;
            System.out.println("Players matched.");
            new Thread(() -> game.playSingleGame(tmp, p2)).start();
            
            p1 = null;
        }
    }
    
}
