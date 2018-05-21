package battleshipagain.implementations;

import battleshipagain.IBoard;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PeterBoss
 */
public class HashMapBoard implements IBoard {

    public final int xSize;
    public final int ySize;
    private HashMap<Position, Integer> board = new HashMap();

    public HashMapBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                board.put(new Position(i, j), 0);
            }
        }
    }

    @Override
    public boolean checkForGameOver() {
        return !board.containsValue(1);
    }

    @Override
    public void placeShip(Position p, Ship s, Boolean vert) {
        List<Position> candidatePlacement;

        if (vert) {
            candidatePlacement = board.entrySet().stream()
                    .filter(e -> e.getKey().y == p.y)
                    .filter(e -> e.getKey().x >= p.x && e.getKey().x < p.x + s.getSize())
                    .map(e -> e.getKey())
                    .collect(Collectors.toList());
        } else {
            candidatePlacement = board.entrySet().stream()
                    .filter(e -> e.getKey().x == p.x)
                    .filter(e -> e.getKey().y >= p.y && e.getKey().y < p.y + s.getSize())
                    .map(e -> e.getKey())
                    .collect(Collectors.toList());
        }

        
        candidatePlacement.stream().forEach((pos) -> {
            if (board.get(pos) == 0) {
                board.compute(pos, (k, v) -> v == 0 ? 1 : 0);
            } else {
                System.out.println("invalid placement");
            }
        });
    }

    @Override
    public int placeShot(Position p) {
        int i = board.get(p);
        board.put(p, 2);
        return i;
    }

    @Override
    public List<Position> getValidTargets() {
        return board.entrySet().stream()
                .filter(e -> e.getValue() != 2)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public void printBoard() {
        int[][] test = new int[10][10];
        board.forEach((k, v) -> test[k.x][k.y] = v);
        for (int[] a : test) {
            for (int i : a) {
                System.out.print(" " + i);
            }
            System.out.println("");
        }
    }

    @Override
    public int remainingTargets() {
        return board.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .collect(Collectors.toList())
                .size();
    }

}
