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