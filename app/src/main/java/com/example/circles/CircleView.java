package com.example.circles;

import java.util.Random;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CircleView extends View {

    int circles;
    Paint circlePaint;
    Random rand = new Random();

    public CircleView(Context context, int circles) {
        super(context);

        this.circles = circles;
        circlePaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Tiek uzzīmēti tik riņķi cik ir vajadzīgs
        for (int i = 0; i < circles; i++) {

            // Katru reizi tiek uzģenerēta jauna krāsa
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            circlePaint.setColor(Color.argb(255, red, green, blue));

            // Katru reizi tiek uzģenerēts jauns riņķa lielums un atrašanās vieta
            int width = rand.nextInt(getWidth());
            int height = rand.nextInt(getHeight());
            int radius = rand.nextInt(200) + 50;

            canvas.drawCircle(width, height, radius, circlePaint);
        }
    }
}
