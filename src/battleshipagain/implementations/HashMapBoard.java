package battleshipagain.implementations;

import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import battleshipagain.Board;

/**
 *
 * @author PeterBoss
 */
public class HashMapBoard implements Board {

    private final int xSize;
    private final int ySize;
    private final HashMap<Position, Integer> board = new HashMap();

    public HashMapBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        for (int i = 0; i < xSize; i++) {  //generates Positions to fill the map. 0 means empty
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

        if (vert) { //gets positions for proposed ship placement (ex: a size 5 ship gets a list of 5 Positions)
            candidatePlacement = board.entrySet().stream()
                    .filter(e -> e.getKey().y == p.y)  //filters for just positions on vertical plane
                    .filter(e -> e.getKey().x >= p.x && e.getKey().x < p.x + s.getSize()) //filters for just positions needed to fit the ship
                    .map(e -> e.getKey()) //gets just the keys (positions)
                    .collect(Collectors.toList()); //stream collected as a list
        } else {
            candidatePlacement = board.entrySet().stream()  //same but horizontal
                    .filter(e -> e.getKey().x == p.x)
                    .filter(e -> e.getKey().y >= p.y && e.getKey().y < p.y + s.getSize())
                    .map(e -> e.getKey())
                    .collect(Collectors.toList());
        }

        
        candidatePlacement.stream().forEach((pos) -> {
                board.compute(pos, (k, v) -> v == 0 ? 1 : 0); //updates the hashmap, if the player has placed ships on top of each other, they are destroyed where they intersect
        });
    }

    @Override
    public int placeShot(Position p) {
        int i = board.get(p);
        board.put(p, 2);
        return i;
    }

    @Override
    public List<Position> getValidTargets() { //gets a list of all Positions that havent been shot yet
        return board.entrySet().stream()
                .filter(e -> e.getValue() != 2)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    public void printBoard() {
        int[][] test = new int[xSize][ySize];
        board.forEach((k, v) -> test[k.x][k.y] = v);
        for (int[] row : test) {
            for (int val : row) {
                System.out.print(" " + val);
            }
            System.out.println("");
        }
    }

    @Override
    public int remainingTargets() {  //returns number of live targets (not how many ships! Positions)
        return board.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public int sizeX() {
        return xSize;
    }

    @Override
    public int sizeY() {
        return ySize;
    }

}
