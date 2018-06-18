package remote;

import battleshipagain.IGameControl;
import battleshipagain.IPlayer;
import battleshipagain.Ship;
import battleshipagain.implementations.StandardGameControl;
import dk.tobiasgrundtvig.util.socket.ConnectionHandler;
import dk.tobiasgrundtvig.util.socket.SocketConnection;
import dk.tobiasgrundtvig.util.socket.impl.Server;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeterBoss
 */
public class BattleshipServer implements ConnectionHandler {

    private PlayerCall p1;
    
    public static void main(String[] args) {
        Server server = new Server(new BattleshipServer(), 3456);
        server.run();
    }

    public BattleshipServer() {
        p1 = null;
    }

    @Override
    public void handleConnection(SocketConnection conn) {
        System.out.println("Handling new connection");
        if (p1 == null) {
            p1 = new PlayerCall(new BattleshipConnectionImpl(conn));
        } else {
            PlayerCall p2 = new PlayerCall(new BattleshipConnectionImpl(conn));
            
            List<Ship> ships = new ArrayList();
            ships.add(new Ship(5));
            ships.add(new Ship(4));
            ships.add(new Ship(4));
            ships.add(new Ship(3));
            ships.add(new Ship(2));
            
            IGameControl game = new StandardGameControl(ships, 10, 10);
            
            IPlayer tmp = p1;
            
            new Thread(() -> game.playSingleGame(tmp, p2)).start();
            
            p1 = null;
        }
    }
    
}
