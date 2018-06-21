package battleshipagain;

/**
 *
 * @author PeterBoss
 */
public class Ship {
    private final int size;

    public Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        switch (size) {
            case 5:
                return "Carrier";
            case 4:
                return "Battleship";
            case 3:
                return "Submarine/Cruiser";
            case 2:
                return "Destroyer";
            default:
                return "Ship size: " + size;
           
        }
    }
    
    
    
    
}
