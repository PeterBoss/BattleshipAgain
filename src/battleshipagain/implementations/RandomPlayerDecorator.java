/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipagain.implementations;

import battleshipagain.BattleshipPlayer;
import battleshipagain.Board;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author Peter
 */
// RandomPlayer that is doesnt print to console
public class RandomPlayerDecorator implements BattleshipPlayer {

    private final BattleshipPlayer player = new RandomPlayer();
    PrintStream originalStream = System.out;
    PrintStream dummyStream = new PrintStream(new OutputStream() {
        public void write(int b) {
            // nothing 
        }
    });

    @Override
    public void startGame(int playerId) {
        System.setOut(dummyStream);
        player.startGame(playerId);
        System.setOut(originalStream);
    }

    @Override
    public void placeShips(List<Ship> ships, Board board) {
        System.setOut(dummyStream);
        player.placeShips(ships, board);
        System.setOut(originalStream);
    }

    @Override
    public Position takeTurn(List<Position> validTargets) {
        System.setOut(dummyStream);
        Position pos = player.takeTurn(validTargets);
        System.setOut(originalStream);
        return pos;
    }

    @Override
    public void endGame(int result) {
        System.setOut(dummyStream);
        player.endGame(result);
        System.setOut(originalStream);
    }

}
