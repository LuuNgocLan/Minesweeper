package app.min.luungoclan.minesweeper;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Luu Ngoc Lan on 25-Apr-18.
 */

public class Cell extends Sprite {

    public boolean isRevealed;
    public boolean isBomb;
    public boolean isCheat;
    private ArrayList<Cell> neighbors;
    private  int bombNeighborCount;

    public Cell(GameView gameView, Bitmap sheet, int x, int y,boolean isBomb) {
        super(gameView, sheet, x, y,3,4);
        this.isBomb = isBomb;
        this.isRevealed = false;
        this.isCheat = false;
        this.bombNeighborCount = 0;
        this.neighbors = new ArrayList<Cell>();
    }

    public void addNeighbors(Cell neighbor){
        this.neighbors.add(neighbor);
        if(neighbor.isBomb){
            this.bombNeighborCount++;
        }
    }

    public ArrayList<Cell> getNeighbors(){
        return this.neighbors;
    }

    public int getBombNeighborCount(){
        return  this.bombNeighborCount;
    }

    public void reveal(){
        this.isRevealed = true;
    }

}
