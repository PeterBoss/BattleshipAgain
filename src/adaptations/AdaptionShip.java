/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaptations;

import battleship.interfaces.Ship;

/**
 *
 * @author Peter
 */
class AdaptionShip implements Ship {

    private final int size;
    
    public AdaptionShip(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
    
}
