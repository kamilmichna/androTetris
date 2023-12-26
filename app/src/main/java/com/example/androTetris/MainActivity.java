package com.example.androTetris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {
    GameState gameState;
    MatrixView canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.canvas = findViewById(R.id.canvas);
        this.gameState = new GameState(canvas);
        tick();
    }


    public void moveLeft(View v) {
        if (gameState.activeObject.xPos > 0) {
            gameState.activeObject.xPos--;
        }
    }

    public void rotate(View v) {
        this.gameState.rotate();
    }

    public void moveRight(View v) {
        if (gameState.activeObject.xPos + gameState.activeObject.activeVariant.matrix[0].length < 10) {
            gameState.activeObject.xPos++;
        }
    }

    public void tick() {
        GameState currentState = this.gameState;
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currentState.onTick();
                canvas.setMatrix(currentState.matrix.matrix);
            }
        }, 0 ,500);
    }
}