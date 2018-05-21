
package battleshipagain;

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
        
        int winner = ctrl.playSingleGame(new RandomPlayer(), new RandomPlayer());
        System.out.println(winner);
        
    }
    
}
