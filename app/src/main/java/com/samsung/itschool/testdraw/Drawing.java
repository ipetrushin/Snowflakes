package com.samsung.itschool.testdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

class Snowflake {
    public Snowflake() {
        // 1) сгенерировать случайные координаты и скорость
        // в пределах от 0 до 1
    }

    float x, y, velocity;
    public void fall() {
        y += velocity;
        // 2) предусмотреть перерождение снежинки
    }
}

public class Drawing extends View {
    float x = 100, y = 0, radius =100;
    Snowflake[] snowflakes;
    Paint p = new Paint();
    float w, h;
    public Drawing(Context context) {
        super(context);
    }

    public Drawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snowflakes = new Snowflake[15];
        // падение снежинок при касании
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w = getWidth();
        h = getHeight();
        canvas.drawColor(Color.YELLOW);
        p.setColor(Color.parseColor("#FF0000"));
        canvas.drawCircle(x,y, radius, p);
        // 3) нарисовать всё снежинки
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (int i = 0; i < 15; i++) {
            snowflakes[i].fall();
        }
       
        invalidate();
        return true;

    }
}
