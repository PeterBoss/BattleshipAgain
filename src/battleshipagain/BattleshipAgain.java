
package battleshipagain;

import adaptations.OldPlayerAdapter;
import battleshipagain.implementations.RandomPlayer;
import battleshipagain.implementations.StandardGameControl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeterBoss
 */
public class BattleshipAgain {

    
    public static void main(String[] args) {
        
        List<Ship> ships = new ArrayList();
        ships.add(new Ship(5));
        ships.add(new Ship(4));
        ships.add(new Ship(4));
        ships.add(new Ship(3));
        ships.add(new Ship(2));
        
        
        StandardGameControl ctrl = new StandardGameControl(ships, 10, 10);
        
        IPlayer p1 = new RandomPlayer();
        IPlayer p2 = new OldPlayerAdapter();
        
        int[] score = ctrl.playManyGames(p1, p2, 100);
        
        int p1Wins = 0;
        int p2Wins = 0;
        
        for (int i : score) {
            if (i == 0) continue;
            if (i == 1) {
                p1Wins++;
            } else {
                p2Wins++;
            }
        }
        System.out.println(p1Wins + " - " + p2Wins);
        
    }
    
}
