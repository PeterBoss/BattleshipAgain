package remote;

import battleshipagain.IPlayer;
import battleshipagain.implementations.RandomPlayer;
import dk.tobiasgrundtvig.util.socket.SocketConnection;
import dk.tobiasgrundtvig.util.socket.impl.SocketConnectionImpl;
import java.io.IOException;

/**
 *
 * @author PeterBoss
 */
public class TestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        System.out.println("Starting client...");
        SocketConnection conn = new SocketConnectionImpl("localhost", 3456);
        IPlayer player = new RandomPlayer();
        RemotePlayer remote = new RemotePlayer(new BattleshipConnectionImpl(conn), player);
        remote.run();
        System.out.println("Done!");

    }
    
}
