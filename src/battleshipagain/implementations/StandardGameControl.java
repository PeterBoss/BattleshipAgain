package battleshipagain.implementations;

import battleshipagain.IBoard;
import battleshipagain.IGameControl;
import battleshipagain.IPlayer;
import battleshipagain.Position;
import battleshipagain.Ship;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeterBoss
 */
public class StandardGameControl implements IGameControl{

    
    private List<Ship> ships;
    private int xSize;
    private int ySize;

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
        if (b1Targets != 18 || b2Targets != 18) {  //hardcoded for 18 for now (5,4,4,3,2)
            if (b1Targets == 18) {
                return 1;
            }
            if (b2Targets == 18) {
                return 2;
            }
            return 0;
        }
        
        while (true) {
            b2.placeShot(p1.takeTurn(b2.getValidTargets()));
            if (b2.checkForGameOver()) {
                return 1; //player 1 wins
            }
            b1.placeShot(p2.takeTurn(b1.getValidTargets()));
            if (b1.checkForGameOver()) {
                return 2; //player 2 wins
            }
            
        }
        
    }
    
    
}
