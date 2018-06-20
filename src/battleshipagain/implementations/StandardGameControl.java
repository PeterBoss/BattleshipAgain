package battleshipagain.implementations;

import battleshipagain.IBoard;
import battleshipagain.IGameControl;
import battleshipagain.IPlayer;
import battleshipagain.Ship;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeterBoss
 */
public class StandardGameControl implements IGameControl{

    
    private final List<Ship> ships;
    private final int xSize;
    private final int ySize;

    public StandardGameControl(List<Ship> ships, int xSize, int ySize) {
        this.ships = ships;
        this.xSize = xSize;
        this.ySize = ySize;
    }
    
    @Override
    public int playSingleGame(IPlayer p1, IPlayer p2) {
        
        p1.playGame(1);
        p2.playGame(2);
        
        IBoard b1 = new HashMapBoard(xSize, ySize);
        IBoard b2 = new HashMapBoard(xSize, ySize);
        
        List<Ship> f1 = new ArrayList();
        List<Ship> f2 = new ArrayList();
        
        f1.addAll(ships);
        f2.addAll(ships);
        
        p1.placeShips(f1, b1);
        p2.placeShips(f2, b2);
        
        int b1Targets = b1.remainingTargets();
        int b2Targets = b2.remainingTargets();
        
        //checking if ships were properly placed
        if (b1Targets != 18 || b2Targets != 18) {  //hardcoded at 18 for now (5,4,4,3,2)
            if (b1Targets == 18) {
                return 1;
            }
            if (b2Targets == 18) {
                return 2;
            }
            return 0;
        }
        
        int winner = 0;
        
        for (int i = 0; i < xSize * ySize; i++) {
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
    public int[] playManyGames(IPlayer p1, IPlayer p2, int gameCount) {
        
        int[] scoreBoard = new int[gameCount];
        
        for (int i = 0; i < gameCount; i++) {
            
            scoreBoard[i] = playSingleGame(p1, p2);
            
        }
        
        return scoreBoard;
        
    }
    
}
