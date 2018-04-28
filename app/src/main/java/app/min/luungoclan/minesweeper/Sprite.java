package app.min.luungoclan.minesweeper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Luu Ngoc Lan on 25-Apr-18.
 */

public class Sprite {
    private int x;
    private int y;
    private GameView gameView;
    private Bitmap sheet;
    private int width;
    private int height;

    public Sprite(GameView gameView, Bitmap bmp, int x, int y, int columns, int rows) {
        this.gameView = gameView;
        this.sheet = bmp;
        this.x = x;
        this.y = y;
        this.width = bmp.getWidth() / columns;
        this.height = bmp.getHeight() / rows;
    }

    public void onDraw(Canvas canvas, int spriteColumn, int spriteRow) {
        Rect src = new Rect((spriteColumn * this.width), (spriteRow * this.height), (spriteColumn * this.width) + width, (spriteRow * this.height) + height);
        Rect dst = new Rect(this.x, this.y, this.x + this.width, this.y + this.height);
        canvas.drawBitmap(this.sheet, src, dst, null);
    }

    public boolean hasCollided(float otherX, float otherY) {
        return this.x < otherX && this.y < otherY && this.x + this.width > otherX && this.y + this.height > otherY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
