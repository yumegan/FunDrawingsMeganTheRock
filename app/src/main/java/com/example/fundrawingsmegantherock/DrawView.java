package com.example.fundrawingsmegantherock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private Paint p = new Paint();
    private int y=0, dY=5;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        System.out.println("width & height" + width + " " + height);

        p.setStyle(Paint.Style.FILL);

        p.setColor(getResources().getColor(R.color.blue_light));
        canvas.drawRect(0,0,width, height, p);

        p.setColor(getResources().getColor(R.color.green_mid));
        canvas.drawRect(0,1200,width, height, p);

        p.setColor(getResources().getColor(R.color.yellow_mid));
        canvas.drawCircle(width, 0, 200, p);

        //sun rays


        p.setColor(getResources().getColor(R.color.pink_light));
        canvas.drawCircle(width/2, height/2, 400, p);

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

        //eyes




//        p.setColor(Color.LTGRAY);
//        canvas.drawCircle(100,y, 20F, p);
//        p.setColor(Color.BLUE);
//        canvas.drawCircle(400,200, 100F, p);
//
//        y+=dY;
//        y%=getHeight();
        invalidate();
    }


    public int getdY(){
        return dY;
    }
    public void setdY(int dY){
        this.dY = dY;
    }
}
