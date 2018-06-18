package remote;

import battleshipagain.IBoard;
import battleshipagain.Position;
import battleshipagain.Ship;
import dk.tobiasgrundtvig.util.socket.SocketConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleshipConnectionImpl implements BattleshipConnection {

    private final SocketConnection conn;

    public BattleshipConnectionImpl(SocketConnection conn) {
        this.conn = conn;
    }

    @Override
    public String readString() throws IOException {
        return conn.readUTF();
    }

    @Override
    public void writeString(String str) throws IOException {
        conn.writeUTF(str);
    }

    @Override
    public int readInt() throws IOException {
        return conn.readInt();
    }

    @Override
    public void writeInt(int playerId) throws IOException {
        conn.writeInt(playerId);
    }

    @Override
    public List<Position> readValidTargets() throws IOException {
        List<Position> targets = new ArrayList();
        int length = conn.readInt();
        for (int i = 0; i < length; i++) {
            targets.add(readPosition());
        }
        return targets;
    }

    @Override
    public void writeValidTargets(List<Position> validTargets) throws IOException {
        conn.writeInt(validTargets.size());
        for (Position p : validTargets) {
            writePosition(p);
        }
    }

    @Override
    public Position readPosition() throws IOException {
        String[] coords = conn.readUTF().split(",");
        return new Position(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

    @Override
    public void writePosition(Position pos) throws IOException {
        conn.writeUTF(pos.x + "," + pos.y);
    }

    @Override
    public void close() throws IOException {
        conn.close();
    }

    @Override
    public IBoard readBoard() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ship> readShips() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeBoard(IBoard board) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeShips(List<Ship> ships) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
