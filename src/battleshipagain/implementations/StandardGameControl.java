package battleshipagain.implementations;

import battleshipagain.Ship;
import java.util.ArrayList;
import java.util.List;
import battleshipagain.BattleshipPlayer;
import battleshipagain.Board;
import battleshipagain.GameControl;

/**
 *
 * @author PeterBoss
 */
public class StandardGameControl implements GameControl{

    
    private final List<Ship> ships;
    private final int xSize;
    private final int ySize;

    public StandardGameControl(List<Ship> ships, int xSize, int ySize) {
        this.ships = ships;
        this.xSize = xSize;
        this.ySize = ySize;
    }
    
    @Override
    public int playSingleGame(BattleshipPlayer p1, BattleshipPlayer p2) {
        
        p1.startGame(1);
        p2.startGame(2);
        
        Board b1 = new HashMapBoard(xSize, ySize);
        Board b2 = new HashMapBoard(xSize, ySize);
        
        List<Ship> f1 = new ArrayList();
        List<Ship> f2 = new ArrayList();
        
        f1.addAll(ships);
        f2.addAll(ships);
        
        p1.placeShips(f1, b1);
        p2.placeShips(f2, b2);
        
        int b1Targets = b1.remainingTargets();
        int b2Targets = b2.remainingTargets();
        
        //checking if ships were properly placed
        if (b1Targets != 17 || b2Targets != 17) {  //hardcoded at 17 for now (5,4,3,3,2)
            if (b1Targets == 17) {
                return 1;
            }
            if (b2Targets == 17) {
                return 2;
            }
            return 0;
        }
        
        int winner = 0;
        
        for (int i = 0; i < xSize * ySize; i++) { // for a 10x10 board, 100 turns should be max
            b2.placeShot(p1.takeTurn(b2.getValidTargets())); 
            
            if (b2.checkForGameOver()) {
                winner = 1;
                break;
            }
            b1.placeShot(p2.takeTurn(b1.getValidTargets()));
            if (b1.checkForGameOver()) {
                winner = 2;
                break;
            }
        }
        
        p1.endGame(winner);
        p2.endGame(winner);
        
        return winner;
        
    }
    
    @Override
    public int[] playManyGames(BattleshipPlayer p1, BattleshipPlayer p2, int gameCount) {
        
        int[] scoreBoard = new int[gameCount];
        
        for (int i = 0; i < gameCount; i++) {
            
            scoreBoard[i] = playSingleGame(p1, p2);
            
        }
        
        return scoreBoard;
        
    }
    
}
