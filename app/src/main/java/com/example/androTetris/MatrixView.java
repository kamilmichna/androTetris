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
    private char[][] matrix;

    public MatrixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas){
        int width = this.getWidth();
        int height = this.getHeight();
        System.out.println(height);
        System.out.println();
        canvas.drawColor(Color.rgb(0,0,0));
        Paint redPaint = new Paint();
        redPaint.setColor(Color.rgb(255, 0, 0));


        drawVerticalGrid(canvas,width,height);
        drawHorizontalGrid(canvas,width,height);
        drawMatrix(canvas, matrix,width,height);
    }

    private void drawVerticalGrid(Canvas canvas, int width, int height) {
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.rgb(255, 255, 255));
        int cellWidth = width / 10;
        for (int i = 0; i < 9; i++ ) {
            canvas.drawLine(cellWidth * (i + 1), 0,   cellWidth * (i + 1), height, whitePaint );
        }
    }

    private void drawHorizontalGrid(Canvas canvas, int width, int height) {
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.rgb(255, 255, 255));
        int cellWidth = height / 20;
        for (int i = 0; i < 19; i++ ) {
            canvas.drawLine(0, cellWidth * (i + 1) + 1,  width, cellWidth * (i + 1) + 1, whitePaint );
        }
    }

    private void drawMatrix(Canvas canvas, char[][] matrix, int width, int height) {
        int cellSize = width / 10;
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 10; y++) {
                if (matrix[x][y] == 'z') {
                    //incactive blocks
                    Paint redPaint = new Paint();
                    System.out.println("ASD");
                    redPaint.setColor(Color.rgb(255, 0, 0));
                    canvas.drawRect(new Rect(y * cellSize, x * cellSize, y * cellSize + cellSize, x * cellSize + cellSize), redPaint);
                } else if (matrix[x][y] == 'y') {
                    //active blocks
                    Paint bluePaint = new Paint();
                    System.out.println("ASD");
                    bluePaint.setColor(Color.rgb(0, 0, 255));
                    canvas.drawRect(new Rect(y * cellSize, x * cellSize, y * cellSize + cellSize, x * cellSize + cellSize), bluePaint);
                }
            }
        }
    }

    public void setMatrix(char[][] matrix)
    {
        this.matrix = matrix;
    }
}
