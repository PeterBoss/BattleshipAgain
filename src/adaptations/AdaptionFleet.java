/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptations;

import battleship.interfaces.Fleet;
import battleshipagain.Ship;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Peter
 */
public class AdaptionFleet implements Fleet {
    
    AdaptionShip[] ships;

    public AdaptionFleet(List<Ship> ships) {
        
        this.ships = new AdaptionShip[ships.size()];
        
        for (int i = 0; i < ships.size(); i++) {
            this.ships[i] = new AdaptionShip(ships.get(i).getSize());
        }
        
    }

    @Override
    public int getNumberOfShips() {
        return ships.length;
    }

    @Override
    public battleship.interfaces.Ship getShip(int index) {
        return ships[index];
    }

    @Override
    public Iterator<battleship.interfaces.Ship> iterator() {
        return new ShipIterator();
    }
    
    private class ShipIterator implements Iterator<battleship.interfaces.Ship>
    {
        private int index = 0;
        
        @Override
        public boolean hasNext()
        {
            return index < ships.length;
        }

        @Override
        public battleship.interfaces.Ship next()
        {
            return ships[index++];
        }
        
    }
    
}
