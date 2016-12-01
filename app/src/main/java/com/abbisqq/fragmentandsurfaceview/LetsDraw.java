package com.abbisqq.fragmentandsurfaceview;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by babis on 1/10/2016.
 */

public class LetsDraw extends SurfaceView implements Runnable{
    int x,y,z=10;
        Thread t = null;
        SurfaceHolder surfaceHolder;
        boolean screenReady= false;
        Canvas c;


    public LetsDraw(Context context) {
        super(context);
        surfaceHolder = getHolder();
        screenReady=true;

    }

    @Override
    public void run() {
        Paint whitePaint = new Paint();
        whitePaint.setStyle(Paint.Style.STROKE);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setAntiAlias(true);
        whitePaint.setStrokeWidth(20);
        Paint redPaint = new Paint();
        redPaint.setAntiAlias(true);
        redPaint.setColor(Color.RED);
        redPaint.setStrokeWidth(35);

        while (screenReady==true){
            x=10;
            y=10;
            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }else {

                c = surfaceHolder.lockCanvas();
                x = c.getWidth();
                y = c.getHeight();
                c.drawARGB(0,0,0,0);
                c.drawLine(10,10,c.getWidth(),c.getHeight(),whitePaint);
                c.drawLine(10,10,20,20,redPaint);
                surfaceHolder.unlockCanvasAndPost(c);


                try {
                    t.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    public void onPause() {
        screenReady = false;
        while (true) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
    public void onResume(){
        screenReady=true;
        t = new Thread(this);
        t.start();
    }






}
