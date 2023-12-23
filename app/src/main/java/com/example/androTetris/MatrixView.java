package com.example.androTetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MatrixView extends View {
    public MatrixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas){
        int width = this.getWidth();
        int height = this.getHeight();
        System.out.println();
        canvas.drawColor(Color.rgb(0,0,0));

        Paint redPaint = new Paint();
        redPaint.setColor(Color.rgb(255, 0, 0));

        Paint greenPaint = new Paint();
        greenPaint.setColor(Color.rgb(0, 255, 0));

        Paint bluePaint = new Paint();
        bluePaint.setColor(Color.rgb(0, 0, 255));

        drawVerticalGrid(canvas,width,height);
    }

    private void drawVerticalGrid(Canvas canvas, int width, int height) {
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.rgb(255, 255, 255));
        int cellWidth = width / 8;
        for (int i = 0; i < 8; i++ ) {
            canvas.drawLine(0 + cellWidth * (i + 1), 0,  2 + cellWidth * (i + 1), height, whitePaint );
        }
    }

    public void setMatrix(char[][] matrix)
    {
        System.out.println("DRAWING DRAWING");
        System.out.println(matrix.length);
    }
}
