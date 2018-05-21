package battleshipagain.implementations;

import battleshipagain.Cell;
import battleshipagain.CellStatus;
import battleshipagain.IBoard;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PeterBoss
 */
public class ListBoard implements IBoard {

    public final int xSize;
    public final int ySize;
    private List<Cell> board;

    public ListBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                board.add(new Cell(i, j));
            }
        }
    }

    @Override
    public boolean checkForGameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void placeShip(Position p, Ship s, Boolean vert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int placeShot(Position p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Position> getValidTargets() {
        return board.stream()
                .filter(c -> c.getStatus() != CellStatus.HIT)
                .map(c -> new Position(c.x, c.y))
                .collect(Collectors.toList());
    }

    @Override
    public int remainingTargets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
