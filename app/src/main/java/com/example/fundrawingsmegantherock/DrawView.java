package com.example.fundrawingsmegantherock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private Paint p = new Paint();
    private float y=0, dY=5;
    private int move=0, dMove=5;
    private float width, height;
    private float GROUND = 1200;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        y = height/2;
        System.out.println("width & height" + width + " " + height);

        p.setStyle(Paint.Style.FILL);

        // sky
        p.setColor(getResources().getColor(R.color.blue_light));
        canvas.drawRect(0,0,width, height, p);

        // sun
        p.setColor(getResources().getColor(R.color.yellow_mid));
        canvas.drawCircle(width, 0, 200, p);

        //sun rays
        p.setAlpha(200);
        drawRays(canvas, p, GROUND, 10);
        p.setAlpha(255);

        // ground
        p.setColor(getResources().getColor(R.color.green_mid));
        canvas.drawRect(0,GROUND,width, height, p);

        // PIG BOD
        p.setColor(getResources().getColor(R.color.pink_light));
        canvas.drawCircle(width/2, height/2, 400, p);
        y+=dY;
        y%=50;

        p.setStyle(Paint.Style.STROKE);
        p.setColor(getResources().getColor(R.color.pink_2));
        p.setStrokeWidth(10);
        canvas.drawCircle(width/2, height/2, 400, p);
        canvas.drawCircle(width/2, height*11/20, 200, p);
        canvas.drawCircle(380, 865, 50, p);
        canvas.drawCircle(700, 865, 50, p);

        //RectF rect = new RectF(width-50, 200, width+50, 400);
        RectF rect = new RectF(width/2-150, height/2+100, width/2+150, height/2+250);
        canvas.drawOval(rect, p);

        canvas.drawLine(900, 1100, 1000, 1080, p);

        //nose holes
        p.setStyle(Paint.Style.FILL);
        canvas.drawOval(width/2-80, height/2+135, width/2-40, height/2+210, p);
        canvas.drawOval(width/2+40, height/2+135, width/2+80, height/2+210, p);

        //eyes
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.DKGRAY);
        RectF circ = new RectF(width/2-80, height/2, width/2-40, height/2+40);
        canvas.drawArc(circ, 20, 160, false, p);
        circ = new RectF(width/2+40, height/2, width/2+80, height/2+40);
        canvas.drawArc(circ, 20, 160, false, p);


//        p.setColor(Color.LTGRAY);
//        canvas.drawCircle(100,y, 20F, p);
//        p.setColor(Color.BLUE);
//        canvas.drawCircle(400,200, 100F, p);
//
//        y+=dY;
//        y%=getHeight();
        invalidate();
    }

    public void drawRays(Canvas canvas, Paint p, float ymax, int numrays){
        Path wallpath = new Path();
        wallpath.reset(); // only needed when reusing this path for a new build

        wallpath.moveTo(width, 0); // used for first point

        for(int i = -2; i < numrays; i++) {
            //wallpath.moveTo(width, 0); // used for first point
            wallpath.lineTo(0, ymax/numrays*i+150+move);
            wallpath.lineTo(0, ymax/numrays*i+200+move);
            wallpath.lineTo(width, 0);

            //canvas.drawPath(wallpath, p);
        }

        for(int i = 0; i < numrays; i++) {
            //wallpath.moveTo(width, 0); // used for first point
            wallpath.lineTo(width/numrays*i+150+move, GROUND);
            wallpath.lineTo(width/numrays*i+200+move, GROUND);
            wallpath.lineTo(width, 0);

            //canvas.drawPath(wallpath, p);
        }

        move+=dMove;
        move%=50;

        canvas.drawPath(wallpath, p);
    }


    public float getdY(){
        return dY;
    }
    public void setdY(float dY){
        this.dY = dY;
    }
}
