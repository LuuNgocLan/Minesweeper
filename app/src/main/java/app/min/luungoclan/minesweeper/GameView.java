package app.min.luungoclan.minesweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Luu Ngoc Lan on 25-Apr-18.
 */

public class GameView extends SurfaceView {
    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;
    public Context context;
    private Board gameBoard;
    private Game game;
    private long lastClick;

    public GameView(Context context) {
        super(context);
        this.context = context;
        this.gameLoopThread = new GameLoopThread(this);
        this.game = new Game(this, 10, 20);
        this.game.start();
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = false;
                gameLoopThread.setRunning(false);
                while(retry) {
                    try {
                        gameLoopThread.join();
                        retry = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }

        });
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        this.game.draw(canvas);
        this.game.gameBoard.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(System.currentTimeMillis() - lastClick > 500) {
            lastClick = System.currentTimeMillis();
            synchronized (getHolder()) {
                this.game.registerTouch(event);
            }
        }
        return true;
    }

}
