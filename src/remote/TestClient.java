package remote;

import adaptations.OldPlayerAdapter;
import battleshipagain.implementations.RandomPlayer;
import dk.tobiasgrundtvig.util.socket.SocketConnection;
import dk.tobiasgrundtvig.util.socket.impl.SocketConnectionImpl;
import java.io.IOException;
import battleshipagain.BattleshipPlayer;

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
        BattleshipPlayer player = new RandomPlayer();
        PlayerImplementationSide is = new PlayerImplementationSide(new BattleshipConnectionImpl(conn), player);
        is.run();
        System.out.println("Done!");

    }
    
}
