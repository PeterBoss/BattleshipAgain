/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipagain;

/**
 *
 * @author PeterBoss
 */
public class Cell {

    public int x;
    public int y;
    private CellStatus status;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

}
