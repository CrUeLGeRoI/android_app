package com.example.tutorial.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;

public class DrawView extends View {
    Paint paint;
    Rect rect1, rect2;
    RectF rect3;
    RelativeLayout layout;
    public DrawView(Context context) {
        super(context);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        rect1 = new Rect(0, 0, 200, 200);
        canvas.translate(canvas.getWidth()/2-100, canvas.getHeight()/2-100);
        canvas.drawRect(rect1,paint);
        paint.setColor(Color.GREEN);
        rect1 = new Rect(50, 50, 150, 150);
        canvas.drawRect(rect1,paint);
//        int[] colors = {Color.DKGRAY, Color.CYAN, Color.GREEN, Color.BLUE, Color.RED, Color.BLACK, Color.YELLOW};
//        int width = canvas.getWidth();
//        int height = canvas.getHeight();
//        canvas.drawColor(Color.WHITE);
//        canvas.save();
//        canvas.translate(width / 2 - 150, height / 2 - 150);
//
//        for (int i = 0; i < colors.length; i++) {
//            paint.setColor(colors[i]);
//            if (i == 0){
//                canvas.drawRect(100,100, 200, 200, paint);
//            }
//            else {
//                canvas.drawRect(i * 100,i * 100, i * 200, i * 200, paint);
//            }
//        }

    }
}
