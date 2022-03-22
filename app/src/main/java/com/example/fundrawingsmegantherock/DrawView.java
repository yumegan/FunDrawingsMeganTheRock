package com.example.fundrawingsmegantherock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
        p.setColor(Color.LTGRAY);
        canvas.drawCircle(100,y, 20F, p);
        p.setColor(Color.BLUE);
        canvas.drawCircle(400,200, 100F, p);

        y+=dY;
        y%=getHeight();
        invalidate();
    }
    public int getdY(){
        return dY;
    }
    public void setdY(int dY){
        this.dY = dY;
    }
}
